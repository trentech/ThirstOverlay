package org.trentech.thirstoverlay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiOverlay extends Gui {

    private final ResourceLocation bar = new ResourceLocation(ThirstOverlay.MODID, "textures/gui/icons.png");

    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            Minecraft mc = Minecraft.getMinecraft();
            
            if(mc.player.isCreative()) {
            	return;
            }
            
            mc.renderEngine.bindTexture(bar);

            int expLevel = mc.player.experienceLevel;
            
            ScaledResolution scale = event.getResolution();

    		int x = scale.getScaledWidth() / 2 + 9;
    		int y = scale.getScaledHeight() - GuiIngameForge.right_height;

    		drawThirstOverlay(expLevel, mc, x, y);
        }
    }
    
    public void drawThirstOverlay(int expLevel, Minecraft mc, int x, int y)
	{
    	if(expLevel > 20) {
        	for(int i = 1; i < 11; i++) {  		
        		drawTexturedModalRect(x, y, 8, 0, 9, 9);

        		x = x+8;
        	}
        	
        	return;
    	}

    	for(int i = 10; i > 0; i--) {  		
    		if(i <= (expLevel / 2)) {
    			drawTexturedModalRect(x, y, 8, 0, 9, 9);
    		} else if(Math.ceil(expLevel / 2) + 1 == i && expLevel % 2 != 0) {
    			drawTexturedModalRect(x, y, 16, 0, 9, 9);
    		} else {
    			drawTexturedModalRect(x, y, 0, 0, 9, 9);
    		}
    		
    		x = x+8;
    	}
    	
		mc.getTextureManager().bindTexture(Gui.ICONS);
	}
}
