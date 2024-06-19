package com.courses.jetpackinstagramapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfilePreviewScreen(modifier: Modifier = Modifier) {
    var selectedItemIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        TopBar(name = "nitin_the_mr.king", modifier = Modifier.padding(10.dp))

        Spacer(modifier = Modifier.height(18.dp))

        ProfileSection()

        Spacer(modifier = Modifier.height(4.dp))

        ProfileDescription(
            displayName = "Android  Developer",
            description = "1.5 Year of coding experience \n" + "Want me to make your app? Send me an email\n" + "1.5 Year of coding experience \n" + "Want me to make your app? Send me an email",
            url = "https://www.linkedin.com/in/nitinpatil99/",
            followedBy = listOf("jetpack_compose", "coding"),
            otherCount = 24
        )

        Spacer(modifier = Modifier.height(15.dp))

        ProfileButtons(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        HighLightedStory(
            highLight = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.pari),
                    text = "❤\uFE0F\uD83D\uDCAB\uD83D\uDE0D"
                ), ImageWithText(
                    image = painterResource(id = R.drawable.miscos), text = "❤\uFE0F"
                ), ImageWithText(
                    image = painterResource(id = R.drawable.jejuri), text = "जेजुरी\uD83D\uDC9B"
                ), ImageWithText(
                    image = painterResource(id = R.drawable.torana),
                    text = "Torana\uD83D\uDEA9❤\uFE0F"
                ), ImageWithText(
                    image = painterResource(id = R.drawable.pandharpur), text = "Tuljapur❤\uFE0F"
                ), ImageWithText(
                    image = painterResource(id = R.drawable.haldi), text = "\uD83D\uDC9B"
                ), ImageWithText(
                    image = painterResource(id = R.drawable.jayhindcollege),
                    text = "\uD83E\uDD19\uD83C\uDFFB"
                ), ImageWithText(
                    image = painterResource(id = R.drawable.kalsubai),
                    text = "भंडारदरा\uD83D\uDE0E\uD83C\uDF0A❤\uFE0F"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.numdance),
                    text = "Bappa❤\uFE0F"
                )
            ), modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        InstagramTabView(
            onTabSelected = { selectedItemIndex = it }, images = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_grid), text = "Posts"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_reels), text = "Reels"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_igtv), text = "IGTV"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.profile), text = "Profile"
                )
            )
        )

        when (selectedItemIndex) {
            0 -> PostSection(
                images = listOf(
                    painterResource(id = R.drawable.haldi),
                    painterResource(id = R.drawable.pandharpur),
                    painterResource(id = R.drawable.miscos),
                    painterResource(id = R.drawable.jejuri),
                    painterResource(id = R.drawable.torana1),
                    painterResource(id = R.drawable.torana),
                    painterResource(id = R.drawable.group),
                    painterResource(id = R.drawable.shaadi),
                    painterResource(id = R.drawable.friends),
                    painterResource(id = R.drawable.photography),
                    painterResource(id = R.drawable.kalsubai1),
                    painterResource(id = R.drawable.kalsubai2),
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}

@Composable
fun TopBar(name: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                overflow = TextOverflow.Ellipsis,
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Dropdown",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }



        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_bell),
                contentDescription = "Bell icon",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                imageVector = Icons.Default.AddCircle,
                contentDescription = "Add",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                painter = painterResource(id = R.drawable.menu_icon),
                contentDescription = "Menu icon",
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )
        }

    }

}

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.nitin),
                modifier = Modifier
                    .size(80.dp)
                    .weight(3f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            ProfileStat(modifier = Modifier.weight(7f))

        }
    }
}


@Composable
fun RoundImage(image: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = image, contentDescription = null, modifier = modifier
            .border(
                width = 1.dp, color = Color.LightGray, shape = CircleShape
            )
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .padding(5.dp)
            .clip(CircleShape)
    )
}


@Composable
fun ProfileStat(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        UserStat(value = "45", text = "posts")
        UserStat(value = "941", text = "followers")
        UserStat(value = "436", text = "following")
    }
}

@Composable
fun UserStat(value: String, text: String) {
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = value, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)
        Text(text = text)
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int,
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }
    val letterSpacing = 0.5.sp
    val lineHeight = 16.sp

    Column(
        modifier = modifier
            .padding(horizontal = 18.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = letterSpacing,
            fontSize = 14.sp,
            lineHeight = lineHeight
        )

        Text(
            text = if (isExpanded) description else description.take(100) + "...",
            letterSpacing = letterSpacing,
            fontSize = 14.sp,
            lineHeight = lineHeight
        )

        if (description.length > 100) {
            Text(
                text = if (isExpanded) "See less" else "See more",
                color = Color(0xFF3D3D91),
                modifier = Modifier.clickable {
                    isExpanded = !isExpanded
                },
                letterSpacing = letterSpacing,
                fontSize = 14.sp,
                lineHeight = lineHeight
            )
        }


        if (isExpanded) {
            Text(
                text = url,
                color = Color(0xFF3D3D91),
                letterSpacing = letterSpacing,
                fontSize = 14.sp,
                lineHeight = lineHeight
            )
        }

        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black, fontSize = 14.sp, fontWeight = FontWeight.Bold
                    )

                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) append(", ")
                    }

                    if (otherCount > 2) append(" and ")

                    pushStyle(boldStyle)
                    append("$otherCount others")
                }, style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                )
            )
        }
    }
}

@Composable
fun ProfileButtons(modifier: Modifier = Modifier) {
//    val minWidth = 95.dp
    val height = 35.dp

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        CustomButtonForProfile(
            text = "Edit Profile",
            modifier = Modifier
                .weight(0.40f)
                .padding(end = 10.dp)
                .height(height)
        )
        CustomButtonForProfile(
            text = "Share Profile",
            modifier = Modifier
                .weight(0.40f)
                .padding(end = 10.dp)
                .height(height)
        )

        CustomeIconForProfile(
            image = Icons.Default.Person, modifier = Modifier
                .weight(0.1f)
                .height(height)
        )
    }
}


@Composable
fun CustomButtonForProfile(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFEFEFEF)),
        contentAlignment = Alignment.Center
    ) {
        BasicText(
            text = text, style = TextStyle(
                color = Color(0xFF000000), fontSize = 14.sp, fontWeight = FontWeight.SemiBold
            )
        )
    }
}


@Composable
fun CustomeIconForProfile(image: ImageVector, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .background(Color(0xFFEFEFEF)),
        contentAlignment = Alignment.Center
    ) {
        Icon(imageVector = image, contentDescription = null, tint = Color.Black)
    }

}


@Composable
fun HighLightedStory(
    modifier: Modifier = Modifier, highLight: List<ImageWithText>
) {
    LazyRow(
        modifier = modifier
    ) {
        items(highLight.size) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(end = 15.dp)
            ) {
                RoundImage(image = highLight[it].image, modifier = Modifier.size(70.dp))

                Text(
                    text = highLight[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp
                )
            }
        }
    }
}


@Composable
fun InstagramTabView(
    modifier: Modifier = Modifier,
    onTabSelected: (selectedIndex: Int) -> Unit,
    images: List<ImageWithText>
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val inActiveColor = Color(0xFF777777)

    TabRow(
        selectedTabIndex = selectedItem,
        containerColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        images.forEachIndexed { index, item ->
            Tab(selected = selectedItem == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inActiveColor,
                onClick = {
                    selectedItem = index
                    onTabSelected(index)
                }) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedItem == index) Color.Black else inActiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@Composable
fun PostSection(
    modifier: Modifier = Modifier, images: List<Painter>
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.scale(1.01f)                     //for the edges of the image outside of the screen.
    ) {
        items(images.size) {
            Image(
                painter = images[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(width = 1.dp, color = Color.White)
            )
        }
    }
}


//@Composable
//fun ProfileButton(
//    text: String? = null,
//    image: ImageVector? = null,
//    modifier: Modifier = Modifier
//) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.Center,
//        modifier = modifier
//            .border(
//                width = 0.dp,
//                color = Color.LightGray,
//                shape = RoundedCornerShape(4.dp)
//            )
//            .padding(6.dp)
//
//    ) {
//        if (text != null) {
//            Text(text = text, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
//        }
//        if (image != null) {
//            Icon(imageVector = image, contentDescription = null, tint = Color.Black)
//        }
//    }
//}
