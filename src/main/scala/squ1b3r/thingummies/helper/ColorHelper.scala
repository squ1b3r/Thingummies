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

import scala.collection.immutable.SortedMap

object ColorHelper {

  case class Color(code: Int, name: String, dyeName: String)

  final val WHITE = Color(0xFFFFFF, "white", "White")
  final val ORANGE = Color(0xEB8844, "orange", "Orange")
  final val MAGENTA = Color(0xC354CD, "magenta", "Magenta")
  final val LIGHT_BLUE = Color(0x6689D3, "light_blue", "LightBlue")
  final val YELLOW = Color(0xDECF2A, "yellow", "Yellow")
  final val LIME = Color(0x41CD34, "lime", "Lime")
  final val PINK = Color(0xD88198, "pink", "Pink")
  final val GRAY = Color(0x434343, "gray", "Gray")
  final val LIGHT_GRAY = Color(0xABABAB, "light_gray", "LightGray")
  final val CYAN = Color(0x287697, "cyan", "Cyan")
  final val PURPLE = Color(0x7B2FBE, "purple", "Purple")
  final val BLUE = Color(0x253192, "blue", "Blue")
  final val BROWN = Color(0x51301A, "brown", "Brown")
  final val GREEN = Color(0x3B511A, "green", "Green")
  final val RED = Color(0xB3312C, "red", "Red")
  final val BLACK = Color(0x1E1B1B, "black", "Black")

  val COLORS = SortedMap(

    0 -> WHITE,
    1 -> ORANGE,
    2 -> MAGENTA,
    3 -> LIGHT_BLUE,
    4 -> YELLOW,
    5 -> LIME,
    6 -> PINK,
    7 -> GRAY,
    8 -> LIGHT_GRAY,
    9 -> CYAN,
    10 -> PURPLE,
    11 -> BLUE,
    12 -> BROWN,
    13 -> GREEN,
    14 -> RED,
    15 -> BLACK

  ).withDefaultValue(WHITE)

  def getColor(meta: Int): Int = COLORS(meta).code

  def getColorName(meta: Int): String = COLORS(meta).name

  def getDyeName(meta: Int): String = "dye" + COLORS(meta).dyeName
}
