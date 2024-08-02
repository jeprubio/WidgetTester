package com.rumosoft.widgettester.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.clickable
import androidx.glance.appwidget.LinearProgressIndicator
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.preview.ExperimentalGlancePreviewApi
import androidx.glance.preview.Preview
import androidx.glance.semantics.contentDescription
import androidx.glance.semantics.semantics
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider

@Composable
internal fun SampleWidget(modifier: GlanceModifier = GlanceModifier) {
    WidgetContent(
        phone = "678 46 11 44",
        usedData = 2.0f,
        totalData = 6,
        extras = "Termina en 20 días",
        updated = "a las 13:40",
        modifier = modifier,
    )
}

@Composable
internal fun SampleOverflowedWidget(modifier: GlanceModifier = GlanceModifier) {
    WidgetContent(
        phone = "678 46 11 44",
        usedData = 6.7f,
        totalData = 6,
        extras = "Termina en 20 días",
        updated = "a las 13:40",
        modifier = modifier,
    )
}

@Composable
internal fun WidgetContent(
    phone: String,
    usedData: Float,
    totalData: Int,
    extras: String,
    updated: String,
    modifier: GlanceModifier,
) {
    Column(
        modifier = modifier.fillMaxSize()
            .background(GlanceTheme.colors.background)
            .padding(16.dp),
        verticalAlignment = Alignment.Top,
        horizontalAlignment = Alignment.Start
    ) {
        PhoneNumber(phone)
        Spacer(modifier = GlanceModifier.height(8.dp))
        DataInfo(usedData, totalData)
        Spacer(modifier = GlanceModifier.height(8.dp))
        Progress(usedData, totalData)
        Spacer(modifier = GlanceModifier.height(8.dp))
        Extras(extras)
        Updated(updated)
    }
}

@Composable
private fun PhoneNumber(phone: String, modifier: GlanceModifier = GlanceModifier) {
    Text(
        text = phone,
        style = TextStyle(fontSize = 18.sp, color = ColorProvider(Color.Black)),
        modifier = modifier,
    )
}

@Composable
private fun DataInfo(usedData: Float, totalData: Int, modifier: GlanceModifier = GlanceModifier) {
    Column(modifier = modifier) {
        Text(
            text = "$usedData GB",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = ColorProvider(Color.Black),
            ),
        )
        Text(
            text = "de $totalData GB",
            style = TextStyle(
                fontSize = 16.sp,
                color = ColorProvider(Color.Gray),
            )
        )
    }
}

@Composable
fun Progress(
    usedData: Float,
    totalData: Int,
    modifier: GlanceModifier = GlanceModifier
) {
    val description = if (usedData <= totalData)
        "Progress: ${usedData/totalData}*100 %"
    else
        "Overflowed"
    LinearProgressIndicator(
        modifier = modifier
            .fillMaxWidth()
            .height(8.dp)
            .semantics { contentDescription = description },
        progress = usedData / totalData,
        color = if (usedData <= totalData) ColorProvider(Color.Blue)
        else ColorProvider(Color.Red),
        backgroundColor = ColorProvider(Color.LightGray),
    )
}

@Composable
private fun Extras(extras: String, modifier: GlanceModifier = GlanceModifier) {
    Text(
        text = extras,
        style = TextStyle(fontSize = 16.sp, color = ColorProvider(Color.Gray)),
        modifier = modifier,
    )
}

@Composable
private fun Updated(updated: String, modifier: GlanceModifier = GlanceModifier) {
    Text(
        text = updated,
        modifier = modifier.clickable {
            // Do nothing
        },
        TextStyle(
            fontSize = 16.sp,
            color = ColorProvider(Color.Gray)
        ),
    )
}

@OptIn(ExperimentalGlancePreviewApi::class)
@Preview(widthDp = 180, heightDp = 180)
@Composable
private fun PreviewSampleWidget() {
    SampleWidget()
}

@OptIn(ExperimentalGlancePreviewApi::class)
@Preview(widthDp = 180, heightDp = 180)
@Composable
private fun PreviewSampleOverflowedWidget() {
    SampleOverflowedWidget()
}
