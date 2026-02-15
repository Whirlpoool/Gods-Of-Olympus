package whirlpool.gods_of_olympus.Renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.object.projectile.TridentModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.renderer.special.TridentSpecialRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.item.ItemDisplayContext;

public class PoseidonsTridentSpecialRenderer extends TridentSpecialRenderer {
    private final TridentModel model;

    public PoseidonsTridentSpecialRenderer(TridentModel model) {
        super(model);
        this.model = model; }

    @Override
    public void submit(ItemDisplayContext itemDisplayContext, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int i, int i1, boolean b, int i2) {
        poseStack.pushPose();
        poseStack.scale(1.0F, -1.0F, -1.0F);
        submitNodeCollector.submitModelPart(this.model.root(), poseStack, this.model.renderType(ModModelLayers.POSEIDONS_TRIDENT_TEXTURE), i, i1, (TextureAtlasSprite)null, false, b, -1, (ModelFeatureRenderer.CrumblingOverlay)null, i2);
        poseStack.popPose();
    }

    public static record Unbaked() implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<PoseidonsTridentSpecialRenderer.Unbaked> MAP_CODEC = MapCodec.unit(new PoseidonsTridentSpecialRenderer.Unbaked());

        public MapCodec<PoseidonsTridentSpecialRenderer.Unbaked> type() {
            return MAP_CODEC;
        }

        public SpecialModelRenderer<?> bake(SpecialModelRenderer.BakingContext bakingContext) {
            return new PoseidonsTridentSpecialRenderer(new TridentModel(bakingContext.entityModelSet().bakeLayer(ModelLayers.TRIDENT)));
        }
    }
}
