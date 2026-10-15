package com.example.edu_vk.presentation.appdetails

import com.example.edu_vk.data.samplesApp
import com.example.edu_vk.model.AppInfo
val showcaseApps: List<AppInfo> = samplesApp.take(9)
val showcasePages: List<List<AppInfo>> = showcaseApps.chunked(3)