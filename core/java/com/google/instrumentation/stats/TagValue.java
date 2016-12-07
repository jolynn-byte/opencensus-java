/*
 * Copyright 2016, Google Inc.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.instrumentation.stats;

/**
 * Census Tag values.
 *
 * <p>TagValue's are {@link String}s with enforced restrictions.
 */
public final class TagValue {
  public static final int MAX_LENGTH = StringUtil.MAX_LENGTH;

  /**
   * Constructs a new {@link TagValue} from the given string. The string will be sanitize such that:
   * <ol>
   * <li>length is restricted to {@link MAX_LENGTH}, strings longer than that will be truncated.
   * <li>characters are restricted to printable ascii characters, non-printable characters will be
   * replaced by an underscore '_'.
   * </ol>
   */
  public static TagValue create(String value) {
    return new TagValue(value);
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof TagValue) && value.equals(((TagValue) obj).value);
  }

  @Override
  public int hashCode() {
    return value.hashCode();
  }

  @Override
  public String toString() {
    return value;
  }

  private final String value;

  private TagValue(String value) {
    this.value = StringUtil.sanitize(value);
  }
}
