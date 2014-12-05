/*
 * Copyright 2014 Andrey Kutyrev
 *
 * Licensed under the the GNU Public License v3.0;
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.gnu.org/licenses/gpl.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================================
 */
package com.squ1b3r.thingummies.helper

import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound

object NBTHelper {

  /**
   * Returns compound tag for itemStack if exists. Creates an empty one otherwise
   *
   * @param stack ItemStack to check tag existence for
   */
  def getNBTTagCompound(stack: ItemStack): NBTTagCompound = {
    if (stack.stackTagCompound == null) {
      stack.stackTagCompound = new NBTTagCompound
    }
    stack.stackTagCompound
  }

  /**
   * Checks existence of the compound tag
   *
   * @param stack ItemStack to check key existence in
   * @param key Key to check existence for
   */
  def verifyNBTKey(stack: ItemStack, key: String): Boolean = getNBTTagCompound(stack).hasKey(key)

  /**
   * Reads Int value from NBT using given key
   *
   * @param stack stack to read data from
   * @param key Key to read data for
   */
  def readIntegerFromNBT(stack: ItemStack, key: String): Int = getNBTTagCompound(stack).getInteger(key)

  /**
   * Reads String value from NBT using given key
   *
   * @param stack stack to read data from
   * @param key Key to read data for
   */
  def readStringFromNBT(stack: ItemStack, key: String): String = getNBTTagCompound(stack).getString(key)

  /**
   * Reads Boolean value from NBT using given key
   *
   * @param stack stack to read data from
   * @param key Key to read data for
   */
  def readBooleanFromNBT(stack: ItemStack, key: String): Boolean = getNBTTagCompound(stack).getBoolean(key)

  /**
   * Writes given data to given ItemStack with given key
   *
   * @param stack stack to write data for
   * @param key Key to write data with
   * @param value Value to write
   */
  def writeToNBT(stack: ItemStack, key: String, value: Any): ItemStack = {
    val compound = getNBTTagCompound(stack)

    value match {
      case v: Int =>
        compound.setInteger(key, v)
      case v: String =>
        compound.setString(key, v)
      case v: Boolean =>
        compound.setBoolean(key, v)
      case _ =>
        stack // TODO: Probably need to log this...
    }
    stack
  }
}
