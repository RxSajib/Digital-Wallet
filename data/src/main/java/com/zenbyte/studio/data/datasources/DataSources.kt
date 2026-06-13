package com.zenbyte.studio.data.datasources

import com.zenbyte.studio.data.model.BannerDtoItem
import com.zenbyte.studio.data.model.MerchantDto
import com.zenbyte.studio.data.model.Metadata
import com.zenbyte.studio.data.model.PaymentHistoryDto
import com.zenbyte.studio.data.model.ServiceDtoItem
import com.zenbyte.studio.data.model.UserDto
import com.zenbyte.studio.data.model.Wallet

val paymentHistoryResponse = listOf(
    PaymentHistoryDto(
        id = 1,
        title = "Junaedi",
        transactionType = "Top Up",
        timestamp = "2026-06-13T10:30:00Z",
        displayDate = "13 Jun 2026",
        amount = 345.00,
        currency = "BDT",
        currencySymbol = "৳",
        type = "CREDIT",
        status = "SUCCESS",
        iconUrl = "https://static.vecteezy.com/system/resources/previews/036/885/312/non_2x/blue-send-icon-free-png.png"
    ),
    PaymentHistoryDto(
        id = 2,
        title = "DESCO Prepaid",
        transactionType = "Utility Bill",
        timestamp = "2026-06-12T15:45:00Z",
        displayDate = "12 Jun 2026",
        amount = 1800.00,
        currency = "BDT",
        currencySymbol = "৳",
        type = "DEBIT",
        status = "SUCCESS",
        iconUrl = "https://e7.pngegg.com/pngimages/896/350/png-clipart-computer-icons-check-mark-others-miscellaneous-angle.png"
    ),
    PaymentHistoryDto(
        id = 3,
        title = "TGTDPLC Gas",
        transactionType = "Utility Bill",
        timestamp = "2026-06-11T09:12:00Z",
        displayDate = "11 Jun 2026",
        amount = 950.500,
        currency = "BDT",
        currencySymbol = "৳",
        type = "DEBIT",
        status = "SUCCESS",
        iconUrl = "https://e7.pngegg.com/pngimages/896/350/png-clipart-computer-icons-check-mark-others-miscellaneous-angle.png"
    ),
    PaymentHistoryDto(
        id = 4,
        title = "Anika Rahman",
        transactionType = "Send Money",
        timestamp = "2026-06-11T18:22:00Z",
        displayDate = "11 Jun 2026",
        amount = 2500.00,
        currency = "BDT",
        currencySymbol = "৳",
        type = "DEBIT",
        status = "SUCCESS",
        iconUrl = "https://e7.pngegg.com/pngimages/896/350/png-clipart-computer-icons-check-mark-others-miscellaneous-angle.png"
    ),
    PaymentHistoryDto(
        id = 5,
        title = "Shop & Save Mart",
        transactionType = "Merchant Payment",
        timestamp = "2026-06-10T21:05:00Z",
        displayDate = "10 Jun 2026",
        amount = 4250.00,
        currency = "BDT",
        currencySymbol = "৳",
        type = "DEBIT",
        status = "SUCCESS",
        iconUrl = "https://e7.pngegg.com/pngimages/896/350/png-clipart-computer-icons-check-mark-others-miscellaneous-angle.png"
    ),
    PaymentHistoryDto(
        id = 6,
        title = "Asif Iqbal",
        transactionType = "Cash In",
        timestamp = "2026-06-10T11:30:00Z",
        displayDate = "10 Jun 2026",
        amount = 5000.00,
        currency = "BDT",
        currencySymbol = "৳",
        type = "CREDIT",
        status = "SUCCESS",
        iconUrl = "https://static.vecteezy.com/system/resources/previews/036/885/312/non_2x/blue-send-icon-free-png.png"
    ),
    PaymentHistoryDto(
        id = 7,
        title = "Chaldal Grocery",
        transactionType = "Merchant Payment",
        timestamp = "2026-06-09T16:40:00Z",
        displayDate = "9 Jun 2026",
        amount = 1340.00,
        currency = "BDT",
        currencySymbol = "৳",
        type = "DEBIT",
        status = "SUCCESS",
        iconUrl = "https://e7.pngegg.com/pngimages/896/350/png-clipart-computer-icons-check-mark-others-miscellaneous-angle.png"
    ),
    PaymentHistoryDto(
        id = 8,
        title = "Mitu Mobile Point",
        transactionType = "Top Up",
        timestamp = "2026-06-09T08:15:00Z",
        displayDate = "9 Jun 2026",
        amount = 200.00,
        currency = "BDT",
        currencySymbol = "৳",
        type = "CREDIT",
        status = "SUCCESS",
        iconUrl = "https://static.vecteezy.com/system/resources/previews/036/885/312/non_2x/blue-send-icon-free-png.png"
    ),
    PaymentHistoryDto(
        id = 9,
        title = "Dhaka WASA",
        transactionType = "Utility Bill",
        timestamp = "2026-06-08T14:20:00Z",
        displayDate = "8 Jun 2026",
        amount = 620.00,
        currency = "BDT",
        currencySymbol = "৳",
        type = "DEBIT",
        status = "SUCCESS",
        iconUrl = "https://e7.pngegg.com/pngimages/896/350/png-clipart-computer-icons-check-mark-others-miscellaneous-angle.png"
    ),
    PaymentHistoryDto(
        id = 10,
        title = "Foodpanda Delivery",
        transactionType = "Merchant Payment",
        timestamp = "2026-06-08T22:10:00Z",
        displayDate = "8 Jun 2026",
        amount = 480.00,
        currency = "BDT",
        currencySymbol = "৳",
        type = "DEBIT",
        status = "SUCCESS",
        iconUrl = "https://e7.pngegg.com/pngimages/896/350/png-clipart-computer-icons-check-mark-others-miscellaneous-angle.png"
    ),
    PaymentHistoryDto(
        id = 11,
        title = "Tanvir Hasan",
        transactionType = "Send Money",
        timestamp = "2026-06-07T12:05:00Z",
        displayDate = "7 Jun 2026",
        amount = 1500.00,
        currency = "BDT",
        currencySymbol = "৳",
        type = "DEBIT",
        status = "SUCCESS",
        iconUrl = "https://e7.pngegg.com/pngimages/896/350/png-clipart-computer-icons-check-mark-others-miscellaneous-angle.png"
    ),
    PaymentHistoryDto(
        id = 12,
        title = "Agent Cash Out",
        transactionType = "Cash Out",
        timestamp = "2026-06-06T19:30:00Z",
        displayDate = "6 Jun 2026",
        amount = 3000.00,
        currency = "BDT",
        currencySymbol = "৳",
        type = "DEBIT",
        status = "SUCCESS",
        iconUrl = "https://e7.pngegg.com/pngimages/896/350/png-clipart-computer-icons-check-mark-others-miscellaneous-angle.png"
    ),
    PaymentHistoryDto(
        id = 13,
        title = "Daraz Online Retail",
        transactionType = "Merchant Payment",
        timestamp = "2026-06-06T15:22:00Z",
        displayDate = "6 Jun 2026",
        amount = 2150.00,
        currency = "BDT",
        currencySymbol = "৳",
        type = "DEBIT",
        status = "SUCCESS",
        iconUrl = "https://e7.pngegg.com/pngimages/896/350/png-clipart-computer-icons-check-mark-others-miscellaneous-angle.png"
    ),
    PaymentHistoryDto(
        id = 14,
        title = "Bank Transfer Received",
        transactionType = "Bank Deposit",
        timestamp = "2026-06-05T10:00:00Z",
        displayDate = "5 Jun 2026",
        amount = 12500.00,
        currency = "BDT",
        currencySymbol = "৳",
        type = "CREDIT",
        status = "SUCCESS",
        iconUrl = "https://static.vecteezy.com/system/resources/previews/036/885/312/non_2x/blue-send-icon-free-png.png"
    ),
    PaymentHistoryDto(
        id = 15,
        title = "Pathao Ride",
        transactionType = "Transport Payment",
        timestamp = "2026-06-04T18:50:00Z",
        displayDate = "4 Jun 2026",
        amount = 320.00,
        currency = "BDT",
        currencySymbol = "৳",
        type = "DEBIT",
        status = "SUCCESS",
        iconUrl = "https://e7.pngegg.com/pngimages/896/350/png-clipart-computer-icons-check-mark-others-miscellaneous-angle.png"
    ),
    PaymentHistoryDto(
        id = 16,
        title = "Unilever Bangladesh",
        transactionType = "Merchant Payment",
        timestamp = "2026-06-03T11:15:00Z",
        displayDate = "3 Jun 2026",
        amount = 8900.00,
        currency = "BDT",
        currencySymbol = "৳",
        type = "DEBIT",
        status = "SUCCESS",
        iconUrl = "https://e7.pngegg.com/pngimages/896/350/png-clipart-computer-icons-check-mark-others-miscellaneous-angle.png"
    ),
    PaymentHistoryDto(
        id = 17,
        title = "Shwapno Supershop",
        transactionType = "Merchant Payment",
        timestamp = "2026-06-03T20:45:00Z",
        displayDate = "3 Jun 2026",
        amount = 3450.750,
        currency = "BDT",
        currencySymbol = "৳",
        type = "DEBIT",
        status = "SUCCESS",
        iconUrl = "https://e7.pngegg.com/pngimages/896/350/png-clipart-computer-icons-check-mark-others-miscellaneous-angle.png"
    ),
    PaymentHistoryDto(
        id = 18,
        title = "Amaze Consortium",
        transactionType = "Subscription",
        timestamp = "2026-06-02T09:00:00Z",
        displayDate = "2 Jun 2026",
        amount = 1200.00,
        currency = "BDT",
        currencySymbol = "৳",
        type = "DEBIT",
        status = "SUCCESS",
        iconUrl = "https://e7.pngegg.com/pngimages/896/350/png-clipart-computer-icons-check-mark-others-miscellaneous-angle.png"
    ),
    PaymentHistoryDto(
        id = 19,
        title = "Zayan Travel Flight",
        transactionType = "Ticket Booking",
        timestamp = "2026-06-01T14:10:00Z",
        displayDate = "1 Jun 2026",
        amount = 6500.00,
        currency = "BDT",
        currencySymbol = "৳",
        type = "DEBIT",
        status = "SUCCESS",
        iconUrl = "https://e7.pngegg.com/pngimages/896/350/png-clipart-computer-icons-check-mark-others-miscellaneous-angle.png"
    ),
    PaymentHistoryDto(
        id = 20,
        title = "Refund: Daraz Online",
        transactionType = "Refund",
        timestamp = "2026-05-31T17:25:00Z",
        displayDate = "31 May 2026",
        amount = 450.00,
        currency = "BDT",
        currencySymbol = "৳",
        type = "CREDIT",
        status = "SUCCESS",
        iconUrl = "https://static.vecteezy.com/system/resources/previews/036/885/312/non_2x/blue-send-icon-free-png.png"
    )
)

val merchantData = listOf(
    MerchantDto(
        id = 1,
        name = "KFC",
        category = "Fast Food",
        distance_km = 1.2,
        display_distance = "1.2 km",
        rating = 4.8,
        logo_url = "https://download.logo.wine/logo/KFC/KFC-Logo.wine.png",
        created_at = "2026-01-15T08:30:00Z",
        updated_at = "2026-06-10T14:22:18Z"
    ),
    MerchantDto(
        id = 2,
        name = "Burger King",
        category = "Fast Food",
        distance_km = 1.2,
        display_distance = "1.2 km",
        rating = 4.8,
        logo_url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-2Dmh4H4a_Eq7xfpqWT4ulKhoZF9C83PfHQ&s",
        created_at = "2026-01-15T09:15:00Z",
        updated_at = "2026-06-12T11:05:42Z"
    ),
    MerchantDto(
        id = 3,
        name = "Pizza Hut",
        category = "Fast Food",
        distance_km = 1.2,
        display_distance = "1.2 km",
        rating = 4.8,
        logo_url = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/Pizza_hut_logo_international.svg/1280px-Pizza_hut_logo_international.svg.png",
        created_at = "2026-01-16T10:00:00Z",
        updated_at = "2026-06-11T09:45:12Z"
    ),
    MerchantDto(
        id = 4,
        name = "McDonald's",
        category = "Fast Food",
        distance_km = 1.5,
        display_distance = "1.5 km",
        rating = 4.6,
        logo_url = "https://images.seeklogo.com/logo-png/37/1/mcdonalds-logo-png_seeklogo-370359.png",
        created_at = "2026-01-20T14:35:00Z",
        updated_at = "2026-05-28T16:18:00Z"
    ),
    MerchantDto(
        id = 5,
        name = "Domino's Pizza",
        category = "Fast Food",
        distance_km = 0.8,
        display_distance = "0.8 km",
        rating = 4.7,
        logo_url = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Dominos_pizza_logo.svg/3840px-Dominos_pizza_logo.svg.png",
        created_at = "2026-01-22T11:20:00Z",
        updated_at = "2026-06-13T10:00:00Z"
    ),
    MerchantDto(
        id = 6,
        name = "Subway",
        category = "Healthy Fast Food",
        distance_km = 2.1,
        display_distance = "2.1 km",
        rating = 4.3,
        logo_url = "https://rabbitlogo.com/wp-content/uploads/2025/12/subway.jpg",
        created_at = "2026-02-02T07:45:00Z",
        updated_at = "2026-06-01T13:14:22Z"
    ),
    MerchantDto(
        id = 7,
        name = "Chillox",
        category = "Burgers & Shakes",
        distance_km = 1.1,
        display_distance = "1.1 km",
        rating = 4.9,
        logo_url = "https://images.seeklogo.com/logo-png/64/1/chillox-logo-png_seeklogo-647089.png",
        created_at = "2026-02-10T16:00:00Z",
        updated_at = "2026-06-12T22:40:11Z"
    ),
    MerchantDto(
        id = 8,
        name = "Takeout",
        category = "Burgers",
        distance_km = 1.4,
        display_distance = "1.4 km",
        rating = 4.7,
        logo_url = "https://images.deliveryhero.io/image/fd-bd/bd-logos/ca3ho-logo.jpg",
        created_at = "2026-02-12T12:10:00Z",
        updated_at = "2026-06-09T17:55:00Z"
    ),
    MerchantDto(
        id = 9,
        name = "BFC",
        category = "Fried Chicken",
        distance_km = 2.5,
        display_distance = "2.5 km",
        rating = 4.2,
        logo_url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRU-YXcx5Ch5JLyaiq3yCSD_3T__dy345tFzA&s",
        created_at = "2026-02-18T09:30:00Z",
        updated_at = "2026-04-20T11:12:34Z"
    ),
    MerchantDto(
        id = 10,
        name = "Madchef",
        category = "Fast Food",
        distance_km = 1.7,
        display_distance = "1.7 km",
        rating = 4.6,
        logo_url = "https://images.deliveryhero.io/image/fd-bd/bd-logos/ce2hc-logo.jpg",
        created_at = "2026-03-01T15:20:00Z",
        updated_at = "2026-06-11T14:30:22Z"
    ),
    MerchantDto(
        id = 11,
        name = "Secret Recipe",
        category = "Cakes & Fast Food",
        distance_km = 3.0,
        display_distance = "3.0 km",
        rating = 4.5,
        logo_url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTv_ifX2uyWaZ4wU4LYWNfsWewjnH2o400OWg&s",
        created_at = "2026-03-05T11:00:00Z",
        updated_at = "2026-06-05T09:20:15Z"
    ),
    MerchantDto(
        id = 12,
        name = "CP Five Star",
        category = "Fried Chicken",
        distance_km = 0.5,
        display_distance = "0.5 km",
        rating = 4.4,
        logo_url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAROfHGeE9v752LisKINpTRvJQckxuVGWkFQ&s",
        created_at = "2026-03-14T08:15:00Z",
        updated_at = "2026-06-13T06:45:00Z"
    ),
    MerchantDto(
        id = 13,
        name = "Sultan's Dine",
        category = "Biryani & Kacchi",
        distance_km = 2.2,
        display_distance = "2.2 km",
        rating = 4.9,
        logo_url = "https://play-lh.googleusercontent.com/8cYViwMN71bYulS1SICTlPgDwhNvx8mRMIaG-YHX1Upt9X6GjHE3IZskL9NkILaOS_sLQoklDgkwL2LHTeag",
        created_at = "2026-03-22T10:40:00Z",
        updated_at = "2026-06-12T19:30:55Z"
    ),
    MerchantDto(
        id = 14,
        name = "Kacchi Bhai",
        category = "Biryani & Kacchi",
        distance_km = 1.9,
        display_distance = "1.9 km",
        rating = 4.8,
        logo_url = "https://cdn.prod.website-files.com/63de61fd6af00b31333c0d3a/63f0729263ea2212dc19bb79_logo-4-removebg-p-500.webp",
        created_at = "2026-04-02T11:50:00Z",
        updated_at = "2026-06-12T21:15:40Z"
    ),
    MerchantDto(
        id = 15,
        name = "Star Kabab",
        category = "Traditional Fast Food",
        distance_km = 2.8,
        display_distance = "2.8 km",
        rating = 4.7,
        logo_url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQ1GQLIVt9Lt9W5pszl2rl5pkcprIPX1Wklw&s",
        created_at = "2026-04-10T06:00:00Z",
        updated_at = "2026-06-10T12:00:00Z"
    )
)

val serviceResponse = listOf(
    ServiceDtoItem(
        id = 1,
        title = "Electricity",
        slug = "electricity",
        icon_url = "https://static.vecteezy.com/system/resources/previews/020/717/790/non_2x/electricity-bill-icon-lighting-utilities-yellow-glowing-light-bulb-house-vector.jpg",
        is_active = true,
        created_at = "2026-01-10T06:00:00Z",
        updated_at = "2026-06-12T10:30:00Z"
    ),
    ServiceDtoItem(
        id = 2,
        title = "Water Bill",
        slug = "water_bill",
        icon_url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPH9jXHbEFZCIAI_D6UpkoSElgnSgP5bUpSQ&s",
        is_active = true,
        created_at = "2026-01-10T06:00:00Z",
        updated_at = "2026-06-12T10:30:00Z"
    ),
    ServiceDtoItem(
        id = 3,
        title = "Phone Credit",
        slug = "phone_credit",
        icon_url = "https://png.pngtree.com/png-clipart/20230925/original/pngtree-flat-credit-card-payment-icon-with-mobile-banking-concept-vector-png-image_12869533.png",
        is_active = true,
        created_at = "2026-01-10T06:00:00Z",
        updated_at = "2026-06-12T10:30:00Z"
    ),
    ServiceDtoItem(
        id = 4,
        title = "Internet",
        slug = "internet",
        icon_url = "https://img.magnific.com/free-photo/online-payment-security-concept-3d-phone-bill_107791-16722.jpg?semt=ais_hybrid&w=740&q=80",
        is_active = true,
        created_at = "2026-01-12T08:15:00Z",
        updated_at = "2026-06-11T14:22:18Z"
    ),
    ServiceDtoItem(
        id = 5,
        title = "E-Money",
        slug = "e_money",
        icon_url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9NBPe1g5XKWEVo-zhKhBc7eZTmsSD076rXQ&s",
        is_active = true,
        created_at = "2026-01-12T08:15:00Z",
        updated_at = "2026-06-11T14:22:18Z"
    ),
    ServiceDtoItem(
        id = 6,
        title = "G-Voucher",
        slug = "g_voucher",
        icon_url = "https://cdn-icons-png.flaticon.com/512/869/869445.png",
        is_active = true,
        created_at = "2026-01-15T09:00:00Z",
        updated_at = "2026-06-05T11:45:12Z"
    ),
    ServiceDtoItem(
        id = 7,
        title = "Netflix",
        slug = "netflix",
        icon_url = "https://images.icon-icons.com/2699/PNG/512/netflix_logo_icon_170919.png",
        is_active = true,
        created_at = "2026-02-01T11:30:00Z",
        updated_at = "2026-06-13T09:12:05Z"
    )
)

val bannerResponse = listOf(
    BannerDtoItem(
        id = 1,
        title = "Big Sale",
        subtitle = "Limited Time Offer",
        badge_text = "BEST DEAL",
        discount_percentage = 45,
        display_discount = "UP TO 45% OFF",
        banner_image_url = "https://static.vecteezy.com/system/resources/previews/002/453/548/non_2x/sale-discount-banner-template-promotion-illustration-free-vector.jpg",
        redirect_type = "merchant_list",
        target_id = "campaign_mega_sale_01",
        is_active = true,
        start_date = "2026-06-01T00:00:00Z",
        end_date = "2026-06-20T23:59:59Z"
    ),
    BannerDtoItem(
        id = 2,
        title = "Friday Feast",
        subtitle = "Weekend Special BOGO",
        badge_text = "1 FOR 1",
        discount_percentage = 50,
        display_discount = "BUY 1 GET 1 FREE",
        banner_image_url = "https://img.magnific.com/free-vector/abstract-big-sale-banner-with-discount-details-modern-design_1017-55230.jpg?semt=ais_hybrid&w=740&q=80",
        redirect_type = "category_filter",
        target_id = "fast_food",
        is_active = true,
        start_date = "2026-06-12T00:00:00Z",
        end_date = "2026-06-14T23:59:59Z"
    ),
    BannerDtoItem(
        id = 3,
        title = "Free Delivery Week",
        subtitle = "On orders over ৳500",
        badge_text = "FREE SHIPPING",
        discount_percentage = 100,
        display_discount = "0 Taka Delivery Fee",
        banner_image_url = "https://static.vecteezy.com/system/resources/thumbnails/023/091/265/small/flash-sale-discount-banner-template-promotion-posts-sale-banner-template-design-web-banner-for-mega-sale-promotion-discount-sale-banner-end-of-season-special-offer-banner-free-vector.jpg",
        redirect_type = "url",
        target_id = "https://api.mockdomain.com/webviews/terms-free-delivery",
        is_active = true,
        start_date = "2026-06-10T00:00:00Z",
        end_date = "2026-06-17T23:59:59Z"
    )
)

val user = UserDto(
    user_id = 1024,
    first_name = "ARIEF",
    last_name = "Roy",
    full_name = "Sajib Roy",
    email = "sajibroy206@gmail.com",
    phone_number = "01771330378",
    avatar_url = "https://cdn.hswstatic.com/gif/play/0b7f4e9b-f59c-4024-9f06-b3dc12850ab7-1920-1080.jpg",
    is_verified_account = true,
    account_status = "VERIFIED",
    wallet = Wallet(
        currency_code = "BDT",
        currency_symbol = "৳",
        current_balance = 385.00,
        points_balance = 1250,
        coinReWard = 25.50
    ),
    metadata = Metadata(
        created_at = "2026-02-15T09:41:00Z",
        updated_at = "2026-06-13T16:12:00Z"
    )
)