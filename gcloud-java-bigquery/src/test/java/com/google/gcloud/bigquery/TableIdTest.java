/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud.bigquery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TableIdTest {

  private static final TableId TABLE = TableId.of("dataset", "table");
  private static final TableId TABLE_COMPLETE = TableId.of("project", "dataset", "table");

  @Test
  public void testOf() {
    assertEquals(null, TABLE.project());
    assertEquals("dataset", TABLE.dataset());
    assertEquals("table", TABLE.table());
    assertEquals("project", TABLE_COMPLETE.project());
    assertEquals("dataset", TABLE_COMPLETE.dataset());
    assertEquals("table", TABLE_COMPLETE.table());
  }

  @Test
  public void testEquals() {
    compareTableIds(TABLE, TableId.of("dataset", "table"));
    compareTableIds(TABLE_COMPLETE, TableId.of("project", "dataset", "table"));
  }

  @Test
  public void testToPbAndFromPb() {
    compareTableIds(TABLE, TableId.fromPb(TABLE.toPb()));
    compareTableIds(TABLE_COMPLETE, TableId.fromPb(TABLE_COMPLETE.toPb()));
  }

  private void compareTableIds(TableId expected, TableId value) {
    assertEquals(expected, value);
    assertEquals(expected.project(), value.project());
    assertEquals(expected.dataset(), value.dataset());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
