package com.pony.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/12
 */
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TestEntry {

    private int id;
    private String test;
    private String tep;
}
