package com.dgjalic.gyrosmedievalarmory.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_MEDIEVAL_ARMORY = "key.category.gyrosmedievalarmory";
    public static final String KEY_OPEN_VISOR = "key.gyrosmedievalarmory.open_visor";

    public static final KeyMapping OPEN_VISOR_KEY = new KeyMapping(KEY_OPEN_VISOR, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_BRACKET, KEY_CATEGORY_MEDIEVAL_ARMORY);

}
