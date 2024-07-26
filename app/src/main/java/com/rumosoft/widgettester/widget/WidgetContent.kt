package com.rumosoft.widgettester.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.clickable
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.text.Text

@Composable
fun SampleWidget(modifier: GlanceModifier = GlanceModifier) {
    WidgetContent(
        phone = "678 46 11 44",
        usedData = 0,
        totalData = 6,
        extras = "Termina en 20 días",
        updated = "a las 13:40",
        modifier = modifier,
    )
}

@Composable
internal fun WidgetContent(
    phone: String,
    usedData: Int,
    totalData: Int,
    extras: String,
    updated: String,
    modifier: GlanceModifier,
) {
    Column(
        modifier = modifier.fillMaxSize()
            .background(GlanceTheme.colors.background),
        verticalAlignment = Alignment.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PhoneNumber(phone)
        Spacer(modifier = GlanceModifier.height(8.dp))
        DataInfo(usedData, totalData)
        Spacer(modifier = GlanceModifier.height(8.dp))
        Extras(extras)
        Updated(updated)
    }
}

@Composable
private fun PhoneNumber(phone: String) {
    Text(text = phone, modifier = GlanceModifier.padding(12.dp))
}

@Composable
private fun DataInfo(usedData: Int, totalData: Int) {
    Text("$usedData GB")
    Text("de $totalData GB")
}

@Composable
private fun Extras(extras: String) {
    Text(extras)
}

@Composable
private fun Updated(updated: String) {
    Text(
        text = updated,
        modifier = GlanceModifier.clickable {
            // Do nothing
        }

    )
}
