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
package squ1b3r.thingummies.reference

object Reference {

  object dependentMods {
    final val RedstoneArsenalID = "RedstoneArsenal"
    final val ForgeMultipartID = "ForgeMultipart"
    final val ChiselID = "chisel"
  }

  final val Name = "Thingummies"
  final val ModID = "thingummies"
  final val Dependencies = "required-after:" + dependentMods.RedstoneArsenalID + ";after:" + dependentMods.ForgeMultipartID + ";after:" + dependentMods.ChiselID
  final val Version = "@VERSION@"
}
