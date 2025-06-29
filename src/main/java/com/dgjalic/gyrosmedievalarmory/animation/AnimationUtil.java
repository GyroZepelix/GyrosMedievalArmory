package com.dgjalic.gyrosmedievalarmory.animation;

import net.minecraft.util.Mth;

public class AnimationUtil {
    public static float linearLerp(float timePassedFromCreation, float animationStartTime, float duration, float startLocation, float endLocation) {
        float elapsedTime = timePassedFromCreation - animationStartTime;

        float t = Math.max(0.0f, Math.min(1.0f, elapsedTime / duration));

        return startLocation + (endLocation - startLocation) * t;
    }

    /**
     * Linearly interpolates between a start and end value based on a time parameter,
     * with an ease-in-ease-out effect.
     *
     * @param timePassedFromCreation The total time passed since some arbitrary creation point (e.g., game start).
     * @param animationStartTime The timestamp when the animation officially began.
     * @param duration The total duration of the animation.
     * @param startLocation The starting float value.
     * @param endLocation The ending float value.
     * @return The interpolated float value with ease-in-ease-out.
     */
    public static float easeInEaseOutLerp(float timePassedFromCreation, float animationStartTime, float duration, float startLocation, float endLocation) {
        // Calculate the elapsed time relative to the animation's start.
        float elapsedTime = timePassedFromCreation - animationStartTime;

        // Calculate the raw interpolation factor (t), clamped between 0 and 1.
        float t = Math.max(0.0f, Math.min(1.0f, elapsedTime / duration));

        // Apply the ease-in-ease-out smoothing function to 't'.
        // This specific function is a cubic ease-in-ease-out.
        float easedT = t * t * (3.0f - 2.0f * t);

        // Perform the linear interpolation with the eased 't'.
        return startLocation + (endLocation - startLocation) * easedT;
    }

    public static float sinPI(float f) { return Mth.sin(f * (float) Math.PI); }

    public static float cosPI(float f) { return Mth.cos(f * (float) Math.PI); }
}
