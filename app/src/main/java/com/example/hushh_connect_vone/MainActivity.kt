package com.example.hushh_connect_vone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.example.hushh_connect_vone.data.CardData
import com.example.hushh_connect_vone.data.DataProvider
import com.example.hushh_connect_vone.ui.theme.Hushh_connect_voneTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Hushh_connect_voneTheme {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(Color(0xFF1b2c48), darkIcons = false)
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val currentCardIndex = remember { mutableStateOf(0) }
                    val screenWidthPx = with(LocalDensity.current) { LocalConfiguration.current.screenWidthDp.dp.toPx() }

                    Box(modifier = Modifier.fillMaxSize()) {
                        // TopBar Composable ko Box ke sabse upar add karein
                        TopBar()

                        StackOfCards(
                            currentCardIndex = currentCardIndex,
                            cards = DataProvider.getCards(),
                            modifier = Modifier.padding(top = 48.dp)
                        )

                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            ActionNavigationBar(
                                currentCardIndex = currentCardIndex,
                                cardCount = DataProvider.getCards().size, // Number of cards in the stack
                                screenWidthPx = screenWidthPx
                            )
                            BottomNavigationBar2()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1b2c48))
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Profile Image
            Image(
                painter = painterResource(id = R.drawable.avatar_topbar),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            )

            // App Title with Logo
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.topbarbeforeconnecticon),
                    contentDescription = "Logo",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Connect",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            // Search and Notification Icons
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.search_topbar),
                    contentDescription = "Search",
                    tint = Color.White,
                    modifier = Modifier
                        .size(32.dp) // Set size to 24.dp to match notification icon
                        .padding(end = 8.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.notify_topbar),
                    contentDescription = "Notifications",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp) // Set size to 24.dp
                )
            }
        }
    }
}

@Composable
fun StackOfCards(
    modifier: Modifier = Modifier,
    currentCardIndex: MutableState<Int>,
    cards: List<CardData>
) {
    val imageIndices = remember { mutableStateListOf(*Array(cards.size) { 0 }) }
    val gradientColors = listOf(Color(0xFF1b2c48), Color(0xFF563c69))

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = gradientColors,
                    start = Offset(0f, 0f),
                    end = Offset(0f, Float.POSITIVE_INFINITY)
                )
            )
    ) {
        if (currentCardIndex.value < cards.size) {
            // Show cards
            if (currentCardIndex.value < cards.size - 1) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 44.dp, start = 12.dp, end = 12.dp)
                        .offset(y = 10.dp)
                ) {
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Image(
                                painter = painterResource(id = cards[currentCardIndex.value + 1].images[0].imageRes),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                }
            }

            cards.forEachIndexed { index, cardData ->
                if (index == currentCardIndex.value) {
                    DraggableCard(
                        cardData = cardData,
                        currentCardIndex = currentCardIndex,
                        cardCount = cards.size,
                        imageIndices = imageIndices
                    )
                }
            }
        }
    }
}


@Composable
fun DraggableCard(
    cardData: CardData,
    currentCardIndex: MutableState<Int>,
    cardCount: Int,
    imageIndices: SnapshotStateList<Int>
) {
    val imagesList = cardData.images
    val numberOfImages = imagesList.size

    val screenWidthDp = LocalConfiguration.current.screenWidthDp
    val density = LocalDensity.current
    val screenWidthPx = with(density) { screenWidthDp.dp.toPx() }

    val offsetX = remember { Animatable(0f) }
    var rotation by remember { mutableStateOf(0f) }
    var alpha by remember { mutableStateOf(1f) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(offsetX.value) {
        rotation = (offsetX.value / screenWidthPx) * 30
        alpha = 1f - kotlin.math.abs(offsetX.value) / screenWidthPx
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp, bottom = 140.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .offset { IntOffset(offsetX.value.roundToInt(), 0) }
                .graphicsLayer(
                    rotationZ = rotation,
                    alpha = alpha
                )
                .pointerInput(Unit) {
                    detectTapGestures { tapOffset ->
                        val screenThirdWidth = screenWidthPx / 3
                        if (tapOffset.x < screenThirdWidth) {
                            if (imageIndices[currentCardIndex.value] > 0) {
                                imageIndices[currentCardIndex.value] -= 1
                            }
                        } else if (tapOffset.x > 2 * screenThirdWidth) {
                            if (imageIndices[currentCardIndex.value] < numberOfImages - 1) {
                                imageIndices[currentCardIndex.value] += 1
                            }
                        }
                    }
                }
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDragEnd = {
                            coroutineScope.launch {
                                if (offsetX.value > 300f || offsetX.value < -300f) {
                                    currentCardIndex.value++
                                    offsetX.snapTo(0f)
                                    rotation = 0f
                                    alpha = 1f
                                } else {
                                    offsetX.animateTo(0f)
                                    rotation = 0f
                                    alpha = 1f
                                }
                            }
                        }
                    ) { change, dragAmount ->
                        change.consume()
                        coroutineScope.launch {
                            offsetX.snapTo(offsetX.value + dragAmount.x)
                        }
                    }
                },
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                val currentImageData = imagesList[imageIndices[currentCardIndex.value]]
                val isFifthImage = (imageIndices[currentCardIndex.value] == 4)
                val backgroundImageRes = if (imageIndices[currentCardIndex.value] == 3) {
                    R.drawable.discoverpage_imagefour_bg
                } else {
                    currentImageData.imageRes
                }

                Image(
                    painter = painterResource(id = backgroundImageRes),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                if (isFifthImage) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        // Background image
                        Image(
                            painter = painterResource(id = currentImageData.imageRes),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                        // Dark overlay
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(0x88000000)) // Semi-transparent black overlay
                        )

                        // Text and Social Media Icons
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Center) // Aligns the column to the center of the card
                                .padding(bottom = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            // "Connect with" text in white
                            Text(
                                text = "Connect with",
                                style = TextStyle(
                                    fontSize = 27.sp,
                                    lineHeight = 33.sp,
                                    fontFamily = FontFamily(Font(R.font.pacifico)),
                                    fontWeight = FontWeight(400),
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    letterSpacing = 0.1.sp
                                )
                            )

                            // Name with simulated gradient color using a combination of colors
                            Text(
                                text = currentImageData.name + "!",
                                style = TextStyle(
                                    fontSize = 42.sp, // Increased font size for name
                                    lineHeight = 44.sp,
                                    fontFamily = FontFamily(Font(R.font.pacifico)),
                                    fontWeight = FontWeight(400),
                                    textAlign = TextAlign.Center,
                                    letterSpacing = 0.1.sp,
                                    brush = Brush.linearGradient(
                                        colors = listOf(Color(0xFFE54D60), Color(0xFFA342FF))
                                    )
                                )
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            // Social Media Icons
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.linkedin_social), // Replace with your icon resource ID
                                    contentDescription = "LinkedIn",
                                    tint = Color.White,
                                    modifier = Modifier.size(40.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Icon(
                                    painter = painterResource(id = R.drawable.yt_social), // Replace with your icon resource ID
                                    contentDescription = "YouTube",
                                    tint = Color.White,
                                    modifier = Modifier.size(40.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Icon(
                                    painter = painterResource(id = R.drawable.fb_social), // Replace with your icon resource ID
                                    contentDescription = "Facebook",
                                    tint = Color.White,
                                    modifier = Modifier.size(40.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Icon(
                                    painter = painterResource(id = R.drawable.x_social), // Replace with your icon resource ID
                                    contentDescription = "Twitter",
                                    tint = Color.White,
                                    modifier = Modifier.size(40.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Icon(
                                    painter = painterResource(id = R.drawable.insta_social), // Replace with your icon resource ID
                                    contentDescription = "Instagram",
                                    tint = Color.White,
                                    modifier = Modifier.size(40.dp)
                                )
                            }
                        }

                    }
                }



                // Blackish overlay to darken the bottom 50% of the image
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black),
                                startY = with(LocalDensity.current) { (0.5f * LocalConfiguration.current.screenHeightDp.dp).toPx() }
                            )
                        )
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                ) {
                    if (imageIndices[currentCardIndex.value] == 3) {
                        // Product grid for Clara Jane
                        Text(
                            text = currentImageData.name,
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 40.sp,
                                fontFamily = FontFamily(Font(R.font.figtree)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFFFFFFFF),
                                letterSpacing = 0.1.sp,
                            )
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Products",
                            style = TextStyle(
                                fontSize = 32.sp,
                                lineHeight = 48.sp,
                                fontFamily = FontFamily(Font(R.font.figtree)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFFFFFFFF),
                                letterSpacing = 0.1.sp,
                            )
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        // Product Grid
                        val products = currentImageData.products
                        Column {
                            products.chunked(2).forEach { row ->
                                Row {
                                    row.forEach { product ->
                                        Column(
                                            modifier = Modifier
                                                .padding(8.dp)
                                                .weight(1f)
                                        ) {
                                            Image(
                                                painter = painterResource(id = product.productImageRes),
                                                contentDescription = null,
                                                modifier = Modifier
                                                    .height(200.dp)
                                                    .fillMaxWidth()
                                                    .clip(RoundedCornerShape(10.dp)),
                                                contentScale = ContentScale.Crop
                                            )
                                            Spacer(modifier = Modifier.height(8.dp))
                                            Text(
                                                text = product.productName,
                                                style = TextStyle(
                                                    fontSize = 11.sp,
                                                    lineHeight = 17.sp,
                                                    fontFamily = FontFamily(Font(R.font.figtree)),
                                                    fontWeight = FontWeight(600),
                                                    color = Color(0xFFFFFFFF)
                                                )
                                            )
                                            Text(
                                                text = product.productDescription,
                                                style = TextStyle(
                                                    fontSize = 11.sp,
                                                    lineHeight = 17.sp,
                                                    fontFamily = FontFamily(Font(R.font.figtree)),
                                                    fontWeight = FontWeight(400),
                                                    color = Color(0xFFE3E3E3)
                                                )
                                            )
                                            Text(
                                                text = product.productPrice,
                                                style = TextStyle(
                                                    fontSize = 14.sp,
                                                    lineHeight = 23.sp,
                                                    fontFamily = FontFamily(Font(R.font.figtree)),
                                                    fontWeight = FontWeight(400),
                                                    color = Color(0xFFFFFFFF)
                                                )
                                            )
                                        }
                                    }
                                }
                            }
                        }

                    } else {
                        // Default display for other images
                        when (imageIndices[currentCardIndex.value]) {
                            0 -> {
                                // First image content
                                Text(
                                    text = currentImageData.name,
                                    style = TextStyle(
                                        fontSize = 32.sp,
                                        lineHeight = 40.sp,
                                        fontFamily = FontFamily(Font(R.font.figtree)),
                                        fontWeight = FontWeight(700),
                                        color = Color(0xFFFFFFFF),
                                        letterSpacing = 0.1.sp
                                    )
                                )
                                Spacer(modifier = Modifier.height(4.dp)) // 4 dp ka gap
                                Text(
                                    text = "${currentImageData.role} @ ${currentImageData.companyName}",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        lineHeight = 21.sp,
                                        fontFamily = FontFamily(Font(R.font.figtree)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFFFFFFF),
                                        letterSpacing = 0.1.sp
                                    )
                                )
                                Spacer(modifier = Modifier.height(2.dp)) // 4 dp ka gap
                                Text(
                                    text = currentImageData.location,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.figtree)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFFFFFFF),
                                        letterSpacing = 0.1.sp
                                    )
                                )
                                Spacer(modifier = Modifier.height(2.dp)) // 4 dp ka gap

                                Text(
                                    text = currentImageData.description,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily(Font(R.font.figtree)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFFFFFFF),
                                        letterSpacing = 0.1.sp
                                    )
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Read more",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily(Font(R.font.figtree)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF007AFF), // Blue color for "Read more"
                                        letterSpacing = 0.1.sp
                                    ),
                                    modifier = Modifier.clickable {
                                        if (imageIndices[currentCardIndex.value] == 0) {
                                            imageIndices[currentCardIndex.value] = 1
                                        }
                                    }
                                )

                            }
                            1 -> {
                                // Second image content
                                Text(
                                    text = currentImageData.name,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        lineHeight = 40.sp,
                                        fontFamily = FontFamily(Font(R.font.figtree)),
                                        fontWeight = FontWeight(700),
                                        color = Color(0xFFFFFFFF),
                                        letterSpacing = 0.1.sp
                                    )
                                )
                                Text(
                                    text = "${currentImageData.role} @ ${currentImageData.companyName}",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        lineHeight = 30.sp,
                                        fontFamily = FontFamily(Font(R.font.figtree)),
                                        fontWeight = FontWeight(700),
                                        color = Color(0xFFFFFFFF),
                                        letterSpacing = 0.1.sp
                                    )
                                )
                                Text(
                                    text = currentImageData.location,
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        lineHeight = 30.sp,
                                        fontFamily = FontFamily(Font(R.font.figtree)),
                                        fontWeight = FontWeight(700),
                                        color = Color(0xFFFFFFFF),
                                        letterSpacing = 0.1.sp
                                    )
                                )
                                Text(
                                    text = currentImageData.fullDescription,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily(Font(R.font.figtree)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFFFFFFF),
                                        letterSpacing = 0.1.sp
                                    )
                                )
                            }
                            2 -> {
                                // Third image content with experience
                                Text(
                                    text = currentImageData.name,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        lineHeight = 40.sp,
                                        fontFamily = FontFamily(Font(R.font.figtree)),
                                        fontWeight = FontWeight(700),
                                        color = Color(0xFFFFFFFF),
                                        letterSpacing = 0.1.sp
                                    )
                                )
                                Text(
                                    text = "${currentImageData.role} @ ${currentImageData.companyName}",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        lineHeight = 30.sp,
                                        fontFamily = FontFamily(Font(R.font.figtree)),
                                        fontWeight = FontWeight(700),
                                        color = Color(0xFFFFFFFF),
                                        letterSpacing = 0.1.sp
                                    )
                                )
                                Text(
                                    text = currentImageData.location,
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        lineHeight = 30.sp,
                                        fontFamily = FontFamily(Font(R.font.figtree)),
                                        fontWeight = FontWeight(700),
                                        color = Color(0xFFFFFFFF),
                                        letterSpacing = 0.1.sp
                                    )
                                )

                                // Displaying experience in a row
                                currentImageData.experience.forEach { experience ->
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = experience.duration,
                                            style = TextStyle(
                                                fontSize = 14.sp,
                                                fontFamily = FontFamily(Font(R.font.figtree)),
                                                fontWeight = FontWeight(600),
                                                color = Color(0xFFC1FF17), // Yellowish color for experience duration
                                                letterSpacing = 0.1.sp
                                            )
                                        )
                                        Spacer(modifier = Modifier.width(4.dp)) // Space between duration and company
                                        Text(
                                            text = experience.company,
                                            style = TextStyle(
                                                fontSize = 14.sp,
                                                fontFamily = FontFamily(Font(R.font.figtree)),
                                                fontWeight = FontWeight(600),
                                                color = Color(0xFF00FF00), // Green color for experience company
                                                letterSpacing = 0.1.sp
                                            )
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = experience.description,
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            fontFamily = FontFamily(Font(R.font.figtree)),
                                            fontWeight = FontWeight(400),
                                            color = Color(0xFFFFFFFF),
                                            letterSpacing = 0.1.sp
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(8.dp)) // Space between experiences
                                }
                            }
                            else -> {
                                // For other images, you can customize the content as needed
                                Text(
                                    text = " ",
                                    color = Color.White,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }
                }

                // Like and Nope stickers
                if (offsetX.value > 0) {
                    Image(
                        painter = painterResource(id = R.drawable.likehushhconnect),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(20.dp)
                            .alpha(kotlin.math.min(1f, offsetX.value / 300f))
                    )
                } else if (offsetX.value < 0) {
                    Image(
                        painter = painterResource(id = R.drawable.nopehushhconnect),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(20.dp)
                            .alpha(kotlin.math.min(1f, -offsetX.value / 300f))
                    )
                }

                Box(
                    modifier = Modifier
                        .offset(y = 6.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(4.dp)
                            .align(Alignment.TopCenter)
                    ) {
                        for (i in 0 until numberOfImages) {
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .padding(horizontal = 2.dp)
                                    .background(
                                        if (i <= imageIndices[currentCardIndex.value]) Color.White else Color.Gray,
                                        shape = RoundedCornerShape(2.dp)
                                    )
                            )
                        }
                    }
                }
            }
        }
    }
}










@Composable
fun ActionNavigationBar(
    modifier: Modifier = Modifier,
    currentCardIndex: MutableState<Int>,
    cardCount: Int,
    screenWidthPx: Float
) {
    val items = listOf(
        R.drawable.actionbar_discover,
        R.drawable.actionbar_cancel,
        R.drawable.actionbar_superlike,
        R.drawable.actionbar_like,
        R.drawable.actionbar_fifth
    )

    var selectedIndex by remember { mutableStateOf(-1) }
    val coroutineScope = rememberCoroutineScope()
    val offsetX = remember { Animatable(0f) }
    var showImage by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        if (!showImage) { // This condition hides the ActionNavigationBar when showImage is true
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items.forEachIndexed { index, icon ->
                    val bubbleSize = if (index == 1 || index == 3) 62.dp else 48.dp
                    val iconSize = if (index == 1 || index == 3) 30.dp else 22.dp

                    Box(
                        modifier = Modifier
                            .size(bubbleSize)
                            .background(
                                when (index) {
                                    1 -> if (selectedIndex == 1) Color(0xFFF3485B) else Color(0xFF2b2626)
                                    3 -> if (selectedIndex == 3) Color(0xFF199A6A) else Color(0xFF2b2626)
                                    else -> Color(0xFF2b2626)
                                },
                                shape = CircleShape
                            )
                            .clip(CircleShape)
                            .clickable {
                                selectedIndex = index
                                coroutineScope.launch {
                                    showImage = true
                                    delay(500L) // Increased delay to 1 second
                                    when (index) {
                                        1 -> {
                                            // Swipe left action
                                            if (currentCardIndex.value < cardCount) {
                                                offsetX.animateTo(
                                                    targetValue = -screenWidthPx,
                                                    animationSpec = tween(
                                                        durationMillis = 200, // Reduced duration for faster swipe
                                                        easing = LinearOutSlowInEasing
                                                    )
                                                )
                                                currentCardIndex.value++
                                            }
                                        }
                                        3 -> {
                                            // Swipe right action
                                            if (currentCardIndex.value < cardCount) {
                                                offsetX.animateTo(
                                                    targetValue = screenWidthPx,
                                                    animationSpec = tween(
                                                        durationMillis = 200, // Reduced duration for faster swipe
                                                        easing = LinearOutSlowInEasing
                                                    )
                                                )
                                                currentCardIndex.value++
                                            }
                                        }
                                    }
                                    showImage = false // Moved after the animation
                                }
                            }
                            .padding(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = icon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(iconSize)
                                .align(Alignment.Center),
                            colorFilter = when (index) {
                                1 -> if (selectedIndex == 1) ColorFilter.tint(Color(0xFF2b2626)) else null
                                3 -> if (selectedIndex == 3) ColorFilter.tint(Color(0xFF2b2626)) else null
                                else -> null
                            }
                        )
                    }
                }
            }
        }

        if (showImage) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 54.dp, bottom = 140.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = if (selectedIndex == 1) R.drawable.nopehushhconnect else R.drawable.likehushhconnect),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp) // Adjust size as needed
                        .alpha(0.8f) // Adjust transparency as needed
                )
            }
        }
    }
}

@Composable
fun BottomNavigationBar2(modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableStateOf(0) }
    val unselectedColor = Color.Gray
    val selectedGradientBrush = Brush.linearGradient(
        colors = listOf(Color(0xFFE54D60), Color(0xFFA342FF))
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFF111418))
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        val items = listOf(
            R.drawable.discover_navbar,
            R.drawable.community_search_navbar,
            R.drawable.superchat_navbar,
            R.drawable.chat_navbar,
            R.drawable.profile_navbar
        )

        items.forEachIndexed { index, icon ->
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .padding(4.dp)
                    .clickable { selectedIndex = index },
                contentAlignment = Alignment.Center
            ) {
                val selected = index == selectedIndex

                Image(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .graphicsLayer(alpha = if (selected) 0.99f else 1f)
                        .drawWithCache {
                            onDrawWithContent {
                                drawContent()
                                if (selected) {
                                    drawRect(
                                        brush = selectedGradientBrush,
                                        blendMode = BlendMode.SrcAtop
                                    )
                                }
                            }
                        },
                    colorFilter = if (!selected) ColorFilter.tint(unselectedColor) else null
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StackOfCardsPreview() {
    Hushh_connect_voneTheme {
        val currentCardIndex = remember { mutableStateOf(0) }
        val screenWidthPx = with(LocalDensity.current) { LocalConfiguration.current.screenWidthDp.dp.toPx() }
        Box(modifier = Modifier.fillMaxSize()) {
            StackOfCards(
                currentCardIndex = currentCardIndex,
                cards = DataProvider.getCards(),
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier.align(Alignment.BottomCenter),
                verticalArrangement = Arrangement.Bottom
            ) {
                ActionNavigationBar(
                    currentCardIndex = currentCardIndex,
                    cardCount = DataProvider.getCards().size,
                    screenWidthPx = screenWidthPx
                )
                BottomNavigationBar2()
            }
        }
    }
}
