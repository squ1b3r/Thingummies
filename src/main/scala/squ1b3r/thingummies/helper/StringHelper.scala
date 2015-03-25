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
package squ1b3r.thingummies.helper

import java.text.DecimalFormat

import org.lwjgl.input.Keyboard

object StringHelper {

  // When formatting a string, always apply color before font modification.
  val Black: String = 167.toChar + "0"
  val Blue: String = 167.toChar + "1"
  val Green: String = 167.toChar + "2"
  val Teal: String = 167.toChar + "3"
  val Red: String = 167.toChar + "4"
  val Purple: String = 167.toChar + "5"
  val Orange: String = 167.toChar + "6"
  val LightGray: String = 167.toChar + "7"
  val Gray: String = 167.toChar + "8"
  val LightBlue: String = 167.toChar + "9"
  val BrightGreen: String = 167.toChar + "a"
  val BrightBlue: String = 167 + "b"
  val LightRed: String = 167.toChar + "c"
  val Pink: String = 167.toChar + "d"
  val Yellow: String = 167.toChar + "e"
  val White: String = 167.toChar + "f"

  val Obfuscated: String = 167.toChar + "k"
  val Bold: String = 167.toChar + "l"
  val Strikethrough: String = 167.toChar + "m"
  val Underline: String = 167.toChar + "n"
  val Italic: String = 167.toChar + "o"
  val End: String = 167.toChar + "r"

  val ShiftForInfo: String = "Hold " + Yellow + "Shift" + LightGray + " for Details"

  var formatter: DecimalFormat = new DecimalFormat("###,###")

  def isAltKeyDown: Boolean = Keyboard.isKeyDown(Keyboard.KEY_LMENU) || Keyboard.isKeyDown(Keyboard.KEY_RMENU)

  def isControlKeyDown: Boolean = Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_RCONTROL)

  def isShiftKeyDown: Boolean = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)

  def getFormattedNumber(number: Int): String = formatter.format(number)

  // TODO: getChargeText

  // TODO: getEnchantedText

  // TODO: getStatusText

  // TODO: Localization
}
