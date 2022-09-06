package com.eganin.jetpack.thebest.composetest.meditationUI

import com.eganin.jetpack.thebest.composetest.R
import com.eganin.jetpack.thebest.composetest.ui.theme.*

val features =listOf(
    Feature(
        title = "Sleep Meditation",
        R.drawable.ic_headphone,
        BlueViolet1,
        BlueViolet2,
        BlueViolet3,
    ),
    Feature(
        title = "Sleep Meditation",
        R.drawable.ic_videocam,
        LightGreen1,
        LightGreen2,
        LightGreen3,
    ),
    Feature(
        title = "Sleep Meditation",
        R.drawable.ic_headphone,
        OrangeYellow1,
        OrangeYellow2,
        OrangeYellow3,
    ),
    Feature(
        title = "Sleep Meditation",
        R.drawable.ic_headphone,
        Beige1,
        Beige2,
        Beige3,
    ),
)

val bottomMenuItems = listOf(
    BottomMenuContent(title = "Home", iconId = R.drawable.ic_home),
    BottomMenuContent(title = "Meditate", iconId = R.drawable.ic_bubble),
    BottomMenuContent(title = "Sleep", iconId = R.drawable.ic_moon),
    BottomMenuContent(title = "Music", iconId = R.drawable.ic_music),
    BottomMenuContent(title = "Profile", iconId = R.drawable.ic_profile),
)