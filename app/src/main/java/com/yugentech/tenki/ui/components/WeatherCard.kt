package com.yugentech.tenki.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.yugentech.tenki.R
import com.yugentech.tenki.data.mappers.to12HourFormat
import com.yugentech.tenki.data.weather.domain.WeatherState
import kotlin.math.roundToInt

@Composable
fun WeatherCard(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    val colorScheme = MaterialTheme.colorScheme
    val typography = MaterialTheme.typography

    state.weatherInfo?.currentWeatherData?.let { data ->
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = modifier.padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorScheme.surfaceVariant,
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Today ${
                        data.time.to12HourFormat()
                    }",
                    modifier = Modifier.align(Alignment.End),
                    style = typography.titleMedium,
                    color = colorScheme.primary
                )

                Spacer(modifier = Modifier.height(24.dp))

                Image(
                    painter = painterResource(id = data.weatherType.iconRes),
                    contentDescription = null,
                    modifier = Modifier
                        .width(180.dp)
                        .padding(vertical = 8.dp),
                    colorFilter = ColorFilter.tint(colorScheme.primary)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "${data.temperatureCelsius}°C",
                    style = typography.displayMedium,
                    color = colorScheme.primary
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = data.weatherType.weatherDesc,
                    style = typography.titleLarge,
                    color = colorScheme.primary.copy(alpha = 0.8f)
                )

                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    WeatherDataDisplay(
                        value = data.pressure.roundToInt(),
                        unit = "hpa",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                    )

                    WeatherDataDisplay(
                        value = data.humidity.roundToInt(),
                        unit = "%",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_drop),
                    )

                    WeatherDataDisplay(
                        value = data.windSpeed.roundToInt(),
                        unit = "km/h",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
                    )
                }
            }
        }
    }
}