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
package squ1b3r.thingummies.blocks

import squ1b3r.thingummies.reference.Reference

object BlockConfig {

  val decorativeBlockTexturePrefix: String = Reference.ModID + ":decorative/"
  val decorativeBlockNamePrefix: String = "tile." + Reference.ModID + ".decorative."

  final val SlickBlockName = "slick.block"
  final val ShabbyBlockName = "shabby.block"
  final val StainedBlockName = "stained.block"
  final var NoisyBlockName = "noisy.block"

}
