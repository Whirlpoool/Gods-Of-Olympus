package whirlpool.gods_of_olympus.Renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.object.projectile.TridentModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.state.ThrownTridentRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Unit;
import whirlpool.gods_of_olympus.Entities.ThrownHydroTrident;

import java.util.List;

public class HydroTridentRenderer extends EntityRenderer<ThrownHydroTrident, ThrownTridentRenderState> {
    private final TridentModel model;

    public HydroTridentRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new TridentModel(context.bakeLayer(ModelLayers.TRIDENT));
    }


    public void submit(ThrownTridentRenderState renderState, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(renderState.yRot - 90.0F));
        poseStack.mulPose(Axis.ZP.rotationDegrees(renderState.xRot + 90.0F));
        List<RenderType> list = ItemRenderer.getFoilRenderTypes(this.model.renderType(ModModelLayers.HYDRO_TRIDENT_TEXTURE), false, renderState.isFoil);

        for(int i = 0; i < list.size(); ++i) {
            submitNodeCollector.order(i).submitModel(this.model, Unit.INSTANCE, poseStack, (RenderType)list.get(i), renderState.lightCoords, OverlayTexture.NO_OVERLAY, -1, (TextureAtlasSprite)null, renderState.outlineColor, (ModelFeatureRenderer.CrumblingOverlay)null);
        }

        poseStack.popPose();
        super.submit(renderState, poseStack, submitNodeCollector, cameraRenderState);
    }

    @Override
    public ThrownTridentRenderState createRenderState() { return new ThrownTridentRenderState(); }

    public void extractRenderState(ThrownHydroTrident hydroTrident, ThrownTridentRenderState renderState, float p_361066_) {
        super.extractRenderState(hydroTrident, renderState, p_361066_);
        renderState.yRot = hydroTrident.getYRot(p_361066_);
        renderState.xRot = hydroTrident.getXRot(p_361066_);
        renderState.isFoil = hydroTrident.isFoil();
    }
}
