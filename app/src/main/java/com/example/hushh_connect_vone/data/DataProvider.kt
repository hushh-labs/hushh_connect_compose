package com.example.hushh_connect_vone.data

import com.example.hushh_connect_vone.R


object DataProvider {
    fun getCards(): List<CardData> {
        return listOf(
            CardData(
                listOf(
                    ImageData(
                        R.drawable.profile_mix,
                        "Priya, 20",
                        "Designer",
                        "PhonePe",
                        "New York",
                        "Passionate designer shaping user experiences at Disney+ across India, MEA, and SEA. DTU '22 graduate boundaries.",
                        "Passionate designer shaping user experiences at Disney+ across India, MEA, and SEA.\n\n" +
                                "DTU '22 graduate with a strong foundation in design thinking.\n\n" +
                                "Previously crafted seamless interfaces at PhonePe, enhancing user experiences for one of India's top digital payment platforms.\n\n" +
                                "Committed to innovation, I create functional and user-centric designs that push boundaries.",
                        experience = listOf(
                            ExperienceData(
                                "2023-Present",
                                "Disney+ (India, MEA, SEA)",
                                "Remote",
                                "Currently shaping user experiences and designing engaging interfaces for diverse markets."
                            ),
                            ExperienceData(
                                "2022-2023",
                                "PhonePe",
                                "Bangalore, India",
                                "Played a pivotal role in crafting seamless financial solutions and enhancing user experiences for one of India's top digital payment platforms."
                            ),
                            ExperienceData(
                                "2022",
                                "Delhi Technological University (DTU)",
                                "Delhi, India",
                                "Graduated with a degree in design, solidifying my foundation in design thinking and user-centric solutions."
                            )
                        )
                    ),
                    ImageData(
                        R.drawable.profile_female,
                        "Priya, 20",
                        "Designer",
                        "PhonePe",
                        "New York",
                        "Passionate designer shaping user experiences at Disney+ across India, MEA, and SEA. DTU '22 graduate boundaries.",
                        "Passionate designer shaping user experiences at Disney+ across India, MEA, and SEA.\n\n" +
                                "DTU '22 graduate with a strong foundation in design thinking.\n\n" +
                                "Previously crafted seamless interfaces at PhonePe, enhancing user experiences for one of India's top digital payment platforms.\n\n" +
                                "Committed to innovation, I create functional and user-centric designs that push boundaries.",
                        experience = emptyList()
                    ),
                    ImageData(
                        R.drawable.profile_mix,
                        "Priya, 20",
                        "Designer",
                        "PhonePe",
                        "New York",
                        "Passionate designer shaping user experiences at Disney+ across India, MEA, and SEA. DTU '22 graduate boundaries.",
                        "Passionate designer shaping user experiences at Disney+ across India, MEA, and SEA.\n\n" +
                                "DTU '22 graduate with a strong foundation in design thinking.\n\n" +
                                "Previously crafted seamless interfaces at PhonePe, enhancing user experiences for one of India's top digital payment platforms.\n\n" +
                                "Committed to innovation, I create functional and user-centric designs that push boundaries.",
                        experience = listOf(
                            ExperienceData(
                                "2023-Present",
                                "Disney+ (India, MEA, SEA)",
                                "Remote",
                                "Currently shaping user experiences and designing engaging interfaces for diverse markets."
                            ),
                            ExperienceData(
                                "2022-2023",
                                "PhonePe",
                                "Bangalore, India",
                                "Played a pivotal role in crafting seamless financial solutions and enhancing user experiences for one of India's top digital payment platforms."
                            ),
                            ExperienceData(
                                "2022",
                                "Delhi Technological University (DTU)",
                                "Delhi, India",
                                "Graduated with a degree in design, solidifying my foundation in design thinking and user-centric solutions."
                            )
                        )
                    ),
                    ImageData(
                        R.drawable.profile_mix,
                        "Priya",
                        "Product Manager",
                        "Tech Inc.",
                        "San Francisco",
                        "Experienced Product Manager with a passion for developing innovative programs.",
                        "Experienced Product Manager with a passion for developing innovative programs. Skilled in product lifecycle management and cross-functional collaboration.",
                        products = listOf(
                            ProductData(R.drawable.product1, "21WN", "Reversible Angora Cardigan", "$120"),
                            ProductData(R.drawable.product2, "Lamerei", "Reversible Angora Cardigan", "$120"),
                            ProductData(R.drawable.product3, "21WN", "Reversible Angora Cardigan", "$120"),
                            ProductData(R.drawable.product4, "Lamerei", "Reversible Angora Cardigan", "$120")
                        )
                    ),
                    ImageData(
                        R.drawable.profoile_two_female,
                        "Priya",
                        "Content Writer",
                        "Content Hub",
                        "Boston",
                        "Content Writer with experience in creating engaging content for various platforms.",
                        "Creating engaging content for various platforms, focusing on SEO and audience engagement. Previously provided content writing services for blogs, websites, and marketing campaigns, enhancing online presence.",
                        experience = emptyList(),
                        profileName = "Priya",
                        profileLinkedInUrl = "https://www.linkedin.com/in/sonal-profile", // Replace with actual URL
                        profileYouTubeUrl = "https://www.youtube.com/user/sonalchannel", // Replace with actual URL
                        profileFacebookUrl = "https://www.facebook.com/sonal.profile", // Replace with actual URL
                        profileXUrl = "https://twitter.com/sonal_profile", // Replace with actual URL
                        profileInstagramUrl = "https://www.instagram.com/sonal.profile/" // Replace with actual URL
                    )

                )
            ),
            CardData(
                listOf(
                    ImageData(
                        R.drawable.profile_one_male,
                        "Rohan, 25",
                        "Data Scientist",
                        "hushh",
                        "San Francisco",
                        "Data Scientist with experience in developing machine learning models and data-driven solutions.",
                        "Experienced in leading data-driven projects and implementing machine learning models to optimize business solutions. Previously worked at Disney+ and Google, enhancing search algorithms and improving ad targeting systems.",
                        experience = listOf(
                            ExperienceData(
                                "2023-Present",
                                "hushh",
                                "San Francisco, CA",
                                "Leading data-driven projects and implementing machine learning models to optimize business solutions."
                            ),
                            ExperienceData(
                                "2022-2023",
                                "Disney+",
                                "Los Angeles, CA",
                                "Developed data analysis frameworks to support strategic decisions in content creation."
                            ),
                            ExperienceData(
                                "2020-2022",
                                "Google",
                                "Mountain View, CA",
                                "Worked on enhancing search algorithms and improving ad targeting systems."
                            )
                        )
                    ),
                    ImageData(
                        R.drawable.profile_two_male,
                        "Rohan, 25",
                        "Data Scientist",
                        "hushh",
                        "San Francisco",
                        "Data Scientist with experience in developing machine learning models and data-driven solutions.",
                        "Experienced in leading data-driven projects and implementing machine learning models to optimize business solutions. Previously worked at Disney+ and Google, enhancing search algorithms and improving ad targeting systems.",
                        experience = emptyList()
                    ),
                    ImageData(
                        R.drawable.profile_one_male,
                        "Rohan, 25",
                        "Data Scientist",
                        "hushh",
                        "San Francisco",
                        "Data Scientist with experience in developing machine learning models and data-driven solutions.",
                        "Experienced in leading data-driven projects and implementing machine learning models to optimize business solutions. Previously worked at Disney+ and Google, enhancing search algorithms and improving ad targeting systems.",
                        experience = listOf(
                            ExperienceData(
                                "2023-Present",
                                "hushh",
                                "San Francisco, CA",
                                "Leading data-driven projects and implementing machine learning models to optimize business solutions."
                            ),
                            ExperienceData(
                                "2022-2023",
                                "Disney+",
                                "Los Angeles, CA",
                                "Developed data analysis frameworks to support strategic decisions in content creation."
                            ),
                            ExperienceData(
                                "2020-2022",
                                "Google",
                                "Mountain View, CA",
                                "Worked on enhancing search algorithms and improving ad targeting systems."
                            )
                        )
                    ),
                    ImageData(
                        R.drawable.profile_mix,
                        "Rohan",
                        "Product Manager",
                        "Tech Inc.",
                        "San Francisco",
                        "Experienced Product Manager with a passion for developing innovative programs.",
                        "Experienced Product Manager with a passion for developing innovative programs. Skilled in product lifecycle management and cross-functional collaboration.",
                        products = listOf(
                            ProductData(R.drawable.product1, "21WN", "Reversible Angora Cardigan", "$120"),
                            ProductData(R.drawable.product2, "Lamerei", "Reversible Angora Cardigan", "$120"),
                            ProductData(R.drawable.product3, "21WN", "Reversible Angora Cardigan", "$120"),
                            ProductData(R.drawable.product4, "Lamerei", "Reversible Angora Cardigan", "$120")
                        )
                    ),
                    ImageData(
                        R.drawable.profile_one_male,
                        "Rohan",
                        "Content Writer",
                        "Content Hub",
                        "Boston",
                        "Content Writer with experience in creating engaging content for various platforms.",
                        "Creating engaging content for various platforms, focusing on SEO and audience engagement. Previously provided content writing services for blogs, websites, and marketing campaigns, enhancing online presence.",
                        experience = emptyList(),
                        profileName = "Rohan",
                        profileLinkedInUrl = "https://www.linkedin.com/in/sonal-profile", // Replace with actual URL
                        profileYouTubeUrl = "https://www.youtube.com/user/sonalchannel", // Replace with actual URL
                        profileFacebookUrl = "https://www.facebook.com/sonal.profile", // Replace with actual URL
                        profileXUrl = "https://twitter.com/sonal_profile", // Replace with actual URL
                        profileInstagramUrl = "https://www.instagram.com/sonal.profile/" // Replace with actual URL
                    )
                )
            ),
            CardData(
                listOf(
                    ImageData(
                        R.drawable.profoile_two_female,
                        "Anita, 22",
                        "Graphic Designer",
                        "Creative Inc.",
                        "Los Angeles",
                        "Graphic Designer specializing in branding and marketing materials.",
                        "Designing branding and marketing materials for various clients, enhancing brand identity. Previously worked as a freelance designer, focusing on logo and website design.",
                        experience = listOf(
                            ExperienceData(
                                "2023-Present",
                                "Creative Inc.",
                                "Los Angeles, CA",
                                "Designing branding and marketing materials for various clients, enhancing brand identity."
                            ),
                            ExperienceData(
                                "2021-2023",
                                "Freelance",
                                "Remote",
                                "Provided graphic design services to startups and small businesses, focusing on logo and website design."
                            ),
                            ExperienceData(
                                "2019-2021",
                                "DTU Design Studio",
                                "Delhi, India",
                                "Collaborated on university projects, creating visual content and promotional materials."
                            )
                        )
                    ),
                    ImageData(
                        R.drawable.profile_one_female,
                        "Anita, 22",
                        "Graphic Designer",
                        "Creative Inc.",
                        "Los Angeles",
                        "Graphic Designer specializing in branding and marketing materials.",
                        "Designing branding and marketing materials for various clients, enhancing brand identity. Previously worked as a freelance designer, focusing on logo and website design.",
                        experience = emptyList()
                    ),
                    ImageData(
                        R.drawable.profoile_two_female,
                        "Anita, 22",
                        "Graphic Designer",
                        "Creative Inc.",
                        "Los Angeles",
                        "Graphic Designer specializing in branding and marketing materials.",
                        "Designing branding and marketing materials for various clients, enhancing brand identity. Previously worked as a freelance designer, focusing on logo and website design.",
                        experience = listOf(
                            ExperienceData(
                                "2023-Present",
                                "Creative Inc.",
                                "Los Angeles, CA",
                                "Designing branding and marketing materials for various clients, enhancing brand identity."
                            ),
                            ExperienceData(
                                "2021-2023",
                                "Freelance",
                                "Remote",
                                "Provided graphic design services to startups and small businesses, focusing on logo and website design."
                            ),
                            ExperienceData(
                                "2019-2021",
                                "DTU Design Studio",
                                "Delhi, India",
                                "Collaborated on university projects, creating visual content and promotional materials."
                            )
                        )
                    ),
                    ImageData(
                        R.drawable.profile_mix,
                        "Anita",
                        "Product Manager",
                        "Tech Inc.",
                        "San Francisco",
                        "Experienced Product Manager with a passion for developing innovative programs.",
                        "Experienced Product Manager with a passion for developing innovative programs. Skilled in product lifecycle management and cross-functional collaboration.",
                        products = listOf(
                            ProductData(R.drawable.product1, "21WN", "Reversible Angora Cardigan", "$120"),
                            ProductData(R.drawable.product2, "Lamerei", "Reversible Angora Cardigan", "$120"),
                            ProductData(R.drawable.product3, "21WN", "Reversible Angora Cardigan", "$120"),
                            ProductData(R.drawable.product4, "Lamerei", "Reversible Angora Cardigan", "$120")
                        )
                    ),
                    ImageData(R.drawable.profile_female, "Hobbies: Painting, Music", "", "", "", "", "", emptyList())
                )
            ),
            CardData(
                listOf(
                    ImageData(
                        R.drawable.profile_one_male,
                        "Vikram, 23",
                        "Marketing Specialist",
                        "Marketing Pros",
                        "Chicago",
                        "Marketing Specialist with experience in leading campaigns and strategies.",
                        "Leading campaigns and strategies for major clients, increasing brand visibility and market share. Previously worked at AdWorks, developing advertising campaigns and managing client relations.",
                        experience = listOf(
                            ExperienceData(
                                "2022-Present",
                                "Marketing Pros",
                                "Chicago, IL",
                                "Leading campaigns and strategies for major clients, increasing brand visibility and market share."
                            ),
                            ExperienceData(
                                "2020-2022",
                                "AdWorks",
                                "Chicago, IL",
                                "Developed advertising campaigns and managed client relations, contributing to successful product launches."
                            ),
                            ExperienceData(
                                "2018-2020",
                                "Startup Hub",
                                "Remote",
                                "Assisted startups in developing their marketing strategies, focusing on digital marketing and content creation."
                            )
                        )
                    ),
                    ImageData(
                        R.drawable.profile_two_male,
                        "Vikram, 23",
                        "Marketing Specialist",
                        "Marketing Pros",
                        "Chicago",
                        "Marketing Specialist with experience in leading campaigns and strategies.",
                        "Leading campaigns and strategies for major clients, increasing brand visibility and market share. Previously worked at AdWorks, developing advertising campaigns and managing client relations.",
                        experience = emptyList()
                    ),
                    ImageData(
                        R.drawable.profile_one_male,
                        "Vikram, 23",
                        "Marketing Specialist",
                        "Marketing Pros",
                        "Chicago",
                        "Marketing Specialist with experience in leading campaigns and strategies.",
                        "Leading campaigns and strategies for major clients, increasing brand visibility and market share. Previously worked at AdWorks, developing advertising campaigns and managing client relations.",
                        experience = listOf(
                            ExperienceData(
                                "2022-Present",
                                "Marketing Pros",
                                "Chicago, IL",
                                "Leading campaigns and strategies for major clients, increasing brand visibility and market share."
                            ),
                            ExperienceData(
                                "2020-2022",
                                "AdWorks",
                                "Chicago, IL",
                                "Developed advertising campaigns and managed client relations, contributing to successful product launches."
                            ),
                            ExperienceData(
                                "2018-2020",
                                "Startup Hub",
                                "Remote",
                                "Assisted startups in developing their marketing strategies, focusing on digital marketing and content creation."
                            )
                        )
                    ),
                    ImageData(
                        R.drawable.profile_mix,
                        "Vikram",
                        "Product Manager",
                        "Tech Inc.",
                        "San Francisco",
                        "Experienced Product Manager with a passion for developing innovative programs.",
                        "Experienced Product Manager with a passion for developing innovative programs. Skilled in product lifecycle management and cross-functional collaboration.",
                        products = listOf(
                            ProductData(R.drawable.product1, "21WN", "Reversible Angora Cardigan", "$120"),
                            ProductData(R.drawable.product2, "Lamerei", "Reversible Angora Cardigan", "$120"),
                            ProductData(R.drawable.product3, "21WN", "Reversible Angora Cardigan", "$120"),
                            ProductData(R.drawable.product4, "Lamerei", "Reversible Angora Cardigan", "$120")
                        )
                    ),
                    ImageData(R.drawable.profoile_two_female, "Hobbies: Blogging, Photography", "", "", "", "", "", emptyList())
                )
            ),
            CardData(
                listOf(
                    ImageData(
                        R.drawable.profoile_two_female,
                        "Sonal, 21",
                        "Content Writer",
                        "Content Hub",
                        "Boston",
                        "Content Writer with experience in creating engaging content for various platforms.",
                        "Creating engaging content for various platforms, focusing on SEO and audience engagement. Previously provided content writing services for blogs, websites, and marketing campaigns, enhancing online presence.",
                        experience = listOf(
                            ExperienceData(
                                "2021-Present",
                                "Content Hub",
                                "Boston, MA",
                                "Creating engaging content for various platforms, focusing on SEO and audience engagement."
                            ),
                            ExperienceData(
                                "2020-2021",
                                "Freelance",
                                "Remote",
                                "Provided content writing services for blogs, websites, and marketing campaigns, enhancing online presence."
                            ),
                            ExperienceData(
                                "2018-2020",
                                "DTU Literary Society",
                                "Delhi, India",
                                "Contributed articles and short stories, and participated in organizing literary events."
                            )
                        )
                    ),
                    ImageData(
                        R.drawable.profile_mix,
                        "Sonal, 21",
                        "Content Writer",
                        "Content Hub",
                        "Boston",
                        "Content Writer with experience in creating engaging content for various platforms.",
                        "Creating engaging content for various platforms, focusing on SEO and audience engagement. Previously provided content writing services for blogs, websites, and marketing campaigns, enhancing online presence.",
                        experience = emptyList()
                    ),
                    ImageData(
                        R.drawable.profoile_two_female,
                        "Sonal, 21",
                        "Content Writer",
                        "Content Hub",
                        "Boston",
                        "Content Writer with experience in creating engaging content for various platforms.",
                        "Creating engaging content for various platforms, focusing on SEO and audience engagement. Previously provided content writing services for blogs, websites, and marketing campaigns, enhancing online presence.",
                        experience = listOf(
                            ExperienceData(
                                "2021-Present",
                                "Content Hub",
                                "Boston, MA",
                                "Creating engaging content for various platforms, focusing on SEO and audience engagement."
                            ),
                            ExperienceData(
                                "2020-2021",
                                "Freelance",
                                "Remote",
                                "Provided content writing services for blogs, websites, and marketing campaigns, enhancing online presence."
                            ),
                            ExperienceData(
                                "2018-2020",
                                "Literary Society",
                                "Delhi, India",
                                "Contributed articles and short stories, and participated in organizing literary events."
                            )
                        )
                    ),
                    ImageData(
                        R.drawable.profile_mix,
                        "Sonal",
                        "Product Manager",
                        "Tech Inc.",
                        "San Francisco",
                        "Experienced Product Manager with a passion for developing innovative programs.",
                        "Experienced Product Manager with a passion for developing innovative programs. Skilled in product lifecycle management and cross-functional collaboration.",
                        products = listOf(
                            ProductData(R.drawable.product1, "21WN", "Reversible Angora Cardigan", "$120"),
                            ProductData(R.drawable.product2, "Lamerei", "Reversible Angora Cardigan", "$120"),
                            ProductData(R.drawable.product3, "21WN", "Reversible Angora Cardigan", "$120"),
                            ProductData(R.drawable.product4, "Lamerei", "Reversible Angora Cardigan", "$120")
                        )
                    ),
                    ImageData(R.drawable.profile_one_female, "Hobbies: Writing, Reading", "", "", "", "", "", emptyList())
                )
            )
        )
    }
}
