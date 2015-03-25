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

import cpw.mods.fml.common.registry.GameRegistry

import squ1b3r.thingummies.blocks.decorative.DecorativeBlockFactory
import squ1b3r.thingummies.reference.Reference

@GameRegistry.ObjectHolder(Reference.ModID)
object ModBlocks {

  // Decorative Blocks
  var slickBlock = new DecorativeBlockFactory(BlockConfig.SlickBlockName)
  var stainedBlock = new DecorativeBlockFactory(BlockConfig.StainedBlockName)
  var shabbyBlock = new DecorativeBlockFactory(BlockConfig.ShabbyBlockName)

  var noisyBlock = new DecorativeBlockFactory(BlockConfig.NoisyBlockName)


  def preInit(): Unit = {

    // Decorative Blocks
    GameRegistry.registerBlock(slickBlock, classOf[ItemBlockFactory], BlockConfig.SlickBlockName)
    GameRegistry.registerBlock(stainedBlock, classOf[ItemBlockFactory], BlockConfig.StainedBlockName)
    GameRegistry.registerBlock(shabbyBlock, classOf[ItemBlockFactory], BlockConfig.ShabbyBlockName)
    GameRegistry.registerBlock(noisyBlock, classOf[ItemBlockFactory], BlockConfig.NoisyBlockName)

  }
}
