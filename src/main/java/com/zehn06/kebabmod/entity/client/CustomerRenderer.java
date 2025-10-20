package com.zehn06.kebabmod.entity.client;

import com.zehn06.kebabmod.KebabMod;
import com.zehn06.kebabmod.entity.CustomerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.util.Identifier;

public class CustomerRenderer extends MobEntityRenderer<CustomerEntity, PlayerEntityModel<CustomerEntity>> {
	private static final Identifier TEXTURE = new Identifier(KebabMod.MOD_ID, "textures/entity/customer.png");
	
	public CustomerRenderer(EntityRendererFactory.Context context) {
		super(context, new PlayerEntityModel<>(context.getPart(EntityModelLayers.PLAYER), false), 0.5f);
	}
	
	@Override
	public Identifier getTexture(CustomerEntity entity) {
		return TEXTURE;
	}
}
