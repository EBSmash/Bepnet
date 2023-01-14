package com.bep.bepspam;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.lwjgl.Sys;

import static net.minecraftforge.common.MinecraftForge.EVENT_BUS;

@Mod(
        modid = Bepspam.MOD_ID,
        name = Bepspam.MOD_NAME,
        version = Bepspam.VERSION
)
public class Bepspam {

    public static final String MOD_ID = "bepspam";
    public static final String MOD_NAME = "Bepspam";
    public static final String VERSION = "6.9";

    Timer timer;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        EVENT_BUS.register(this);
        timer = new Timer();
    }

    @SubscribeEvent
    public void onChatMessage(ClientChatReceivedEvent event){

        if (!timer.hasReached(60000)) return;

        if (event.getMessage().getFormattedText().toLowerCase().contains("bep")){
            System.out.println("bep detected.");
            Minecraft.getMinecraft().player.sendChatMessage("bep");
            timer.reset();
        }
    }

}
