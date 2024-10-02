package com.sunaa.abc.coordinator.menu

import android.app.Activity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sunaa.abc.R
import com.sunaa.abc.ui.theme.ABCTheme

@Composable
fun MenuItem(
    menuViewModel: MenuViewModel = viewModel()
) {
    val isLanguageVisiable by menuViewModel.isLanguageVisiable.collectAsState()
    val isAppThemeisDark by menuViewModel.appThemeIsDark.collectAsState()
    val languageSeletedIndex by menuViewModel.languageSeletedIndex.collectAsState()
    val context = LocalContext.current
    var themeText: String = stringResource(R.string.enable)
    if (isAppThemeisDark) {
        themeText = stringResource(R.string.disable)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(
                MaterialTheme.colorScheme.background
            )
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = 5.dp)
                .height(40.dp)
                .background(
                    MaterialTheme.colorScheme.background
                )
                .clickable {
                    menuViewModel.updateTheme()
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ThumbUp,
                contentDescription = "dark mode"
            )
            Spacer(Modifier.width(10.dp))
            Text(
                text = "${themeText} ${stringResource(R.string.mode)}",
                fontWeight = FontWeight.Bold
            )
        }
        Divider(thickness = 2.dp)

        Row(
            modifier = Modifier
                .padding(top = 5.dp)
                .height(40.dp)
                .background(
                    MaterialTheme.colorScheme.background
                )
                .clickable {
                    menuViewModel.updateLanguageVisibility()
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "dark mode"
            )
            Spacer(Modifier.width(10.dp))
            Text(
                text = stringResource(R.string.language),
                fontWeight = FontWeight.Bold
            )
        }
        AnimatedVisibility(
            visible = isLanguageVisiable,
            modifier = Modifier.padding(bottom = 5.dp)
        ) {

            Column(modifier = Modifier.padding(10.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            menuViewModel.updateSeletedLanguageIndex(0)
                            menuViewModel.updateLanguage("en")
                        }, // Make the Row span the full width
                    horizontalArrangement = Arrangement.SpaceBetween, // Space items to the left and right
                    verticalAlignment = Alignment.CenterVertically // Center items vertically
                ) {
                    RadioButton(
                        selected = languageSeletedIndex == 0,
                        modifier = Modifier.size(24.dp),
                        onClick = { }
                    )
                    Text(text = stringResource(R.string.lanen))
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            menuViewModel.updateSeletedLanguageIndex(1)
                            menuViewModel.updateLanguage("ja")
                        }, // Make the Row span the full width
                    horizontalArrangement = Arrangement.SpaceBetween, // Space items to the left and right
                    verticalAlignment = Alignment.CenterVertically // Center items vertically
                ) {
                    RadioButton(
                        selected = languageSeletedIndex == 1,
                        modifier = Modifier.size(24.dp),
                        onClick = { menuViewModel.updateSeletedLanguageIndex(1) }
                    )
                    Text(text = stringResource(R.string.lanjp))
                }
            }
        }

        Divider(thickness = 2.dp)

        Row(
            modifier = Modifier
                .padding(top = 5.dp)
                .height(40.dp)
                .background(
                    MaterialTheme.colorScheme.background
                )
                .clickable {
                    (context as Activity).finish()
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "dark mode"
            )
            Spacer(Modifier.width(10.dp))
            Text(
                text = stringResource(R.string.exit),
                fontWeight = FontWeight.Bold
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MenuItemPreview() {
    ABCTheme(isDarkTheme = false) {
        MenuItem()
    }
}