package com.mojito.learn.algorithm.datastructure;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 链表
 *
 * @author liufengqiang
 * @date 2021-02-28 00:40:29
 */
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {

    public int val;
    public ListNode next;

    public static ListNode build(String val) {
        if (val.startsWith("[")) {
            val = val.substring(1, val.length() - 1);
        }

        if (StringUtils.isBlank(val)) {
            return new ListNode();
        }

        return build(Arrays.stream(val.split(",")).map(Integer::valueOf).collect(Collectors.toList()), 0);
    }

    private static ListNode build(List<Integer> vals, int index) {
        if (index >= vals.size()) {
            return null;
        }
        return new ListNode(vals.get(index), build(vals, ++index));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[" + val);
        while (next != null) {
            sb.append(",").append(next.val);
            next = next.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
