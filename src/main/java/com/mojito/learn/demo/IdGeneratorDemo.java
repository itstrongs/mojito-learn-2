package com.mojito.learn.demo;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description 分布式唯一ID生成器
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-04-23 17:19
 */
@Slf4j
public final class IdGeneratorDemo {

    private static final Pattern PATTERN_HOSTNAME = Pattern.compile("^.*\\D+([0-9]+)$");

    private static final long OFFSET = LocalDate.of(2020, 4, 1).atStartOfDay(ZoneId.of("Z")).toEpochSecond();

    private static final long MAX_NEXT = 0b11111_11111111_111L;

    private static final long SHARD_ID = getServerIdAsLong();

    private static long offset = 0;

    private static long lastEpoch = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(nextId());
        }
    }

    public static long nextId() {
        return nextId(System.currentTimeMillis() / 1000);
    }

    private static synchronized long nextId(long epochSecond) {
        if (epochSecond < lastEpoch) {
            // warning: clock is turn back:
            log.warn("clock is back: " + epochSecond + " from previous:" + lastEpoch);
            epochSecond = lastEpoch;
        }
        if (lastEpoch != epochSecond) {
            lastEpoch = epochSecond;
            reset();
        }
        offset++;
        long next = offset & MAX_NEXT;
        if (next == 0) {
            log.warn("maximum id reached in 1 second in epoch: " + epochSecond);
            return nextId(epochSecond + 1);
        }
        return generateId(epochSecond, next, SHARD_ID);
    }

    private static void reset() {
        offset = 0;
    }

    /**
     * 生成id
     *
     * @param epochSecond 时间戳 左移21位相当于后21位丢弃，补0，取 64-21 区间43位 时间戳最大值：2106年时值最大，大于32位
     * @param next        自增数 左移5位相当于占用 64-5 区间的值
     * @param shardId     机器标识 无位移，相当于占 0~64 整个区间的值
     * @return 三个值或运算后 时间戳小于32，所以占了21位 ~ 53位，自增数占后续的5 ~ 21位（16位），机器码占最后5位
     */
    private static long generateId(long epochSecond, long next, long shardId) {
        return ((epochSecond - OFFSET) << 21) | (next << 5) | shardId;
    }

    private static long getServerIdAsLong() {
        try {
            String hostname = InetAddress.getLocalHost().getHostName();
            Matcher matcher = PATTERN_HOSTNAME.matcher(hostname);
            if (matcher.matches()) {
                long n = Long.parseLong(matcher.group(1));
                if (n >= 0 && n < 8) {
                    log.info("detect server id from host name {}: {}.", hostname, n);
                    return n;
                }
            }
        } catch (UnknownHostException e) {
            log.warn("unable to get host name. set server id = 0.");
        }
        return 0;
    }
}
