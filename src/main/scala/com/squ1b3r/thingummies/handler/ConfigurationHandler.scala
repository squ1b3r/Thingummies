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
package com.squ1b3r.thingummies.handler

import com.squ1b3r.thingummies.helper.LogHelper
import com.squ1b3r.thingummies.item.ItemConfig
import com.squ1b3r.thingummies.reference.Reference
import net.minecraftforge.common.config.Configuration

object ConfigurationHandler {

  def loadConfiguration(configuration: Configuration): Unit = {
    try {
      configuration.load()

      // Items
      ItemConfig.update(configuration)

    } catch {
      case exception: Exception =>
        LogHelper.warning(Reference.Name + " failed to load its configuration file.")
    } finally {
      configuration.save()
    }
  }

}
