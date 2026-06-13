package com.zenbyte.studio.digitalwallet.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.PlatformContext
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import com.zenbyte.studio.digitalwallet.R
import com.zenbyte.studio.digitalwallet.ui.theme.adjustedFontSize
import com.zenbyte.studio.digitalwallet.ui.theme.colorGreen
import com.zenbyte.studio.digitalwallet.ui.theme.colorPrimaryLight
import com.zenbyte.studio.domain.model.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileToolbar(user: User, context: PlatformContext) {

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = colorPrimaryLight),
        title = {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                  .padding(top = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {

                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {


                    AsyncImage(
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape),
                        model = ImageRequest.Builder(context).data(user.userProfilePicture).size(500)
                            .build(),
                        error = painterResource(R.drawable.placeholder),
                        placeholder = painterResource(R.drawable.placeholder),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    WidthSpace(width = 10.dp)
                    Column(modifier = Modifier.weight(1f)) {

                        Text(
                            text = user.userName ?: "",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = Color.White,
                                fontWeight = FontWeight.W600
                            ),

                            maxLines = 1,
                            overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                            modifier = Modifier.fillMaxWidth()
                        )

                        HeightSpace(height = 10.dp)
                        Text(
                            text = user.userEmailAddress ?: "",
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = Color.White,
                                fontWeight = FontWeight.W500
                            ),
                            maxLines = 1,
                            overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                            modifier = Modifier.fillMaxWidth(),
                        )
                        Text(
                            text = user.userPhoneNumber ?: "",
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = Color.White,
                                fontWeight = FontWeight.W500
                            ),
                            maxLines = 1,
                            overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                            modifier = Modifier.fillMaxWidth(),
                        )

                        HeightSpace(height = 5.dp)
                        if (user.isVerify) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier

                                    .clip(shape = CircleShape)
                                    .background(color = MaterialTheme.colorScheme.surface)
                                    .padding(horizontal = 10.dp, vertical = 5.dp)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.ic_verified),
                                    contentDescription = null,
                                    modifier = Modifier.size(12.dp),
                                    colorFilter = ColorFilter.tint(color = colorGreen)
                                )
                                WidthSpace(width = 5.dp)
                                Text(
                                    text = stringResource(R.string.verified),
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        fontSize = adjustedFontSize(10f),
                                        color = colorGreen
                                    )
                                )
                            }
                        }

                    }
                }
            }
        }
    )



}

@Composable
fun ProfileToolbarPreview() {
    val context = LocalPlatformContext.current
    ProfileToolbar(
        context = context,
        user = User(
            userID = 1,
            userName = "Sajib Roy",
            balance = 5800.00,
            coinReward = 4.50,
            userEmailAddress = "sajibroy206@gmail.com",
            userPhoneNumber = "+8801771330378",
            userProfilePicture = "",
            isVerify = true
        )
    )
}