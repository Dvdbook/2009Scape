package plugin.activity.gnomecooking.bowls

import core.game.interaction.NodeUsageEvent
import core.game.interaction.UseWithHandler
import core.game.node.item.Item
import core.plugin.InitializablePlugin
import core.plugin.Plugin
import core.tools.ItemNames

private const val GNOME_BOWL_MOLD = 2166
private const val GIANNE_DOUGH = 2171

@InitializablePlugin
class GnomebowlMouldFiller : UseWithHandler(GIANNE_DOUGH) {
    override fun newInstance(arg: Any?): Plugin<Any> {
        addHandler(GNOME_BOWL_MOLD, ITEM_TYPE,this)
        return this
    }

    override fun handle(event: NodeUsageEvent?): Boolean {
        event ?: return false
        val player = event.player
        val used = event.used.asItem()
        val with = event.usedWith.asItem()
        player.inventory.remove(used)
        player.inventory.remove(with)
        player.inventory.add(Item(ItemNames.RAW_GNOMEBOWL_2178))
        return true
    }

}