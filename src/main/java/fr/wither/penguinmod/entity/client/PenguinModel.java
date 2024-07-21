package fr.wither.penguinmod.entity.client;// Made with Blockbench 4.10.3


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import fr.wither.penguinmod.entity.animations.ModAnimationDefinitions;
import fr.wither.penguinmod.entity.custom.PenguinEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class PenguinModel<T extends Entity> extends HierarchicalModel<T> {


	private final ModelPart Whole;
	private final ModelPart Head;

	public PenguinModel(ModelPart root) {
		this.Whole = root.getChild("Whole");
		this.Head = Whole.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Whole = partdefinition.addOrReplaceChild("Whole", CubeListBuilder.create(), PartPose.offset(-0.3F, 16.8F, 0.2F));

		PartDefinition Legs = Whole.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(-1.3F, 7.2F, 0.6F));

		PartDefinition L_Left = Legs.addOrReplaceChild("L_Left", CubeListBuilder.create(), PartPose.offset(3.6F, -2.0F, -0.4F));

		PartDefinition foot_L = L_Left.addOrReplaceChild("foot_L", CubeListBuilder.create().texOffs(18, 26).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -0.4F));

		PartDefinition LegUp = L_Left.addOrReplaceChild("LegUp", CubeListBuilder.create().texOffs(16, 0).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.6F, 2.0F, 0.4F));

		PartDefinition L_Right = Legs.addOrReplaceChild("L_Right", CubeListBuilder.create(), PartPose.offset(-0.5F, -2.0F, -0.5F));

		PartDefinition LegUp1 = L_Right.addOrReplaceChild("LegUp1", CubeListBuilder.create().texOffs(6, 15).addBox(-0.5F, -2.0F, -0.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -0.3F));

		PartDefinition foot_R = L_Right.addOrReplaceChild("foot_R", CubeListBuilder.create().texOffs(26, 23).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -0.3F));

		PartDefinition Body = Whole.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.9F, -10.9F, -1.4F, 6.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.2F, 5.1F, 0.2F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.1F, -1.4F, 1.4F));

		PartDefinition cube_r1 = Tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(18, 20).addBox(-2.0F, 0.0F, -0.1F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3F, -0.7F, 0.5934F, 0.0F, 0.0F));

		PartDefinition wing_left = Body.addOrReplaceChild("wing_left", CubeListBuilder.create().texOffs(9, 20).addBox(0.0F, 0.0F, -1.4F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.1F, -10.0F, 0.0F));

		PartDefinition wing_right = Body.addOrReplaceChild("wing_right", CubeListBuilder.create().texOffs(0, 15).addBox(-1.0F, 0.0F, -1.6F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.9F, -10.0F, 0.2F));

		PartDefinition Head = Whole.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(14, 10).addBox(-2.0F, -4.0F, -2.7F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.3F, -5.8F, 0.5F));

		PartDefinition Beak = Head.addOrReplaceChild("Beak", CubeListBuilder.create().texOffs(19, 0).addBox(-1.0F, -0.4F, -3.1F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.6F, -2.6F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Whole.getAllParts().forEach(ModelPart::resetPose);

		this.applyHeadRotation(netHeadYaw, headPitch);

		this.animateWalk(ModAnimationDefinitions.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((PenguinEntity)entity).idleAnimationState, ModAnimationDefinitions.IDLE, ageInTicks, 1f);
	}

	private void applyHeadRotation(float yaw, float pitch) {
		yaw = Mth.clamp(yaw, -30.0F, 30.0F);
		pitch = Mth.clamp(pitch, -25.0F, 45.0F);


		this.Head.yRot = yaw * ((float)Math.PI / 180.0F);
		this.Head.xRot = pitch * ((float)Math.PI / 180.0F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Whole.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Whole;
	}
}