package com.ak.newsfeed.utils

import android.util.Log
import com.ak.newsfeed.data.remote.Article
import kotlin.random.Random

/**
 *
 * this fake data source class is a testing class that will be used to generate some random data
 *
 */
/**
 * this class provides a List of news item
 * this is how the news item data looks like in JSON format:
 * {
 *         "id" : 0,
 *         "title" : "Design A Simple UI Screen in Flare",
 *         "itemType" : 1,
 *         "newsContent" : "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book. It usually begins with: The purpose of lorem ipsum is to create a natural looking block of text (sentence, paragraph, page, etc.) that doesn't distract from the layout. A practice not without controversy, laying out pages with meaningless filler text can be very useful when the focus is meant to be on design, not content.",
 *         "newsImg" : "https://2.bp.blogspot.com/-ddZ2Tt8EOeo/XxtDIkHWgDI/AAAAAAAAAn0/vG13Vw5zoXU5fy_sHQ_7lW6PQz1UEXocACK4BGAYYCw/s1600/news5.PNG",
 *         "userImg" : "https://2.bp.blogspot.com/-6EcFUPmzExo/XxtD9BbEO4I/AAAAAAAAAo0/n-AxAZrAVLQBbzjcKhkIOHtSLixVUz0lgCK4BGAYYCw/s400/user3.png",
 *         "username" : "Invision Studio",
 *         "date" : "03/08/2020",
 *         "backgroundBg" : "RED"
 *     }
 */
class FakeDataSource {

    fun FakeDataSource() {
        initListNewsImages()
        initListUserImages()
        initListNewsTitle()
        initListUsername()
    }

    /** News item data format
     *
     *   this.id = id;
     *         this.title = title;
     *         this.username = username;
     *         this.newsImg = newsImg;
     *         this.userImg = userImg;
     *         this.newsContent = newsContent;
     *         this.bgColor = bgColor;
     *         this.date = date;
     *         this.viewType = viewType;
     */

    fun getFakeListNews(): MutableList<Article> {
        val data: MutableList<Article> = ArrayList()
        for (index in 0..29) {
            val item = Article(
                id = index,
                title = getRandomNewsTitle(),
                author = getRandomUsername(),
                urlToImage = getRandomNewsImage(),
                authorImage = getRandomUserImage(),
                content = getRandomContent(),
                bgColor = getRandomBgColor(),
                publishedAt = getRandompublishedAt(),
                viewType= generateViewType(index)
            )
            data.add(item)
        }
        return data
    }

    // generate a static list news Items

    // generate a static list news Items
    fun getFakeStaticListNews(): List<Article>? {
        val data: MutableList<Article> = ArrayList()
        data.add(
            Article(
                id = 0,
                title = TXT_TITLE_01,
                author = TXT_NAME_01,
                urlToImage = IMG_NEWS_01,
                authorImage = IMG_USER_01,
                content = LOREM_TEXT,
                bgColor = lstColors[0],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType= 1
            )
        )
        data.add(
            Article(
                id = 1,
                title = TXT_TITLE_02,
                author = TXT_NAME_02,
                urlToImage = IMG_NEWS_02,
                authorImage = IMG_USER_02,
                content = LOREM_TEXT,
                bgColor = lstColors[2],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType= 0
            )
        )
        data.add(
            Article(
                id = 2,
                title = TXT_TITLE_03,
                author = TXT_NAME_03,
                urlToImage = IMG_NEWS_03,
                authorImage = IMG_USER_03,
                content = LOREM_TEXT,
                bgColor = lstColors[0],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType= 0
            )
        )
        data.add(
            Article(
                id = 3,
                title = TXT_TITLE_04,
                author = TXT_NAME_04,
                urlToImage = IMG_NEWS_02,
                authorImage = IMG_USER_04,
                content = LOREM_TEXT,
                bgColor = lstColors[2],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType= 1
            )
        )
        data.add(
            Article(
                id = 4,
                title = TXT_TITLE_05,
                author = TXT_NAME_01,
                urlToImage = IMG_NEWS_03,
                authorImage = IMG_USER_05,
                content = LOREM_TEXT,
                bgColor = lstColors[1],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType= 1
            )
        )
        data.add(
            Article(
                id = 5,
                title = TXT_TITLE_03,
                author = TXT_NAME_01,
                urlToImage = IMG_NEWS_02,
                authorImage = IMG_USER_03,
                content = LOREM_TEXT,
                bgColor = lstColors[1],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType= 0
            )
        )
        data.add(
            Article(
                id = 6,
                title = TXT_TITLE_01,
                author = TXT_NAME_01,
                urlToImage = IMG_NEWS_01,
                authorImage = IMG_USER_01,
                content = LOREM_TEXT,
                bgColor = lstColors[2],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType= 0
            )
        )
        data.add(
            Article(
                id = 7,
                title = TXT_TITLE_01,
                author = TXT_NAME_01,
                urlToImage = IMG_NEWS_01,
                authorImage = IMG_USER_01,
                content = LOREM_TEXT,
                bgColor = lstColors[3],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType= 1
            )
        )
        data.add(
            Article(
                id = 8,
                title = TXT_TITLE_01,
                author = TXT_NAME_01,
                urlToImage = IMG_NEWS_10,
                authorImage = IMG_USER_01,
                content = LOREM_TEXT,
                bgColor = lstColors[2],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType= 1
            )
        )
        data.add(
            Article(
                id = 9,
                title = TXT_TITLE_01,
                author = TXT_NAME_01,
                urlToImage = IMG_NEWS_08,
                authorImage = IMG_USER_01,
                content = LOREM_TEXT,
                bgColor = lstColors[1],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType= 0
            )
        )
        return data
    }

    // generate an updated static news list

    // generate an updated static news list
    fun getFakeUpdatedStaticListNews(): List<Article>? {
        val data: MutableList<Article> = ArrayList()
        data.add(
            Article(
                id = -4,
                title = TXT_TITLE_01,
                author = TXT_NAME_01,
                urlToImage = IMG_NEWS_10,
                authorImage = IMG_USER_01,
                content = LOREM_TEXT,
                bgColor = lstColors[0],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType = 1
            )
        )
        data.add(
            Article(
                id = -3,
                title = TXT_TITLE_02,
                author = TXT_NAME_02,
                urlToImage = IMG_NEWS_02,
                authorImage = IMG_USER_02,
                content = LOREM_TEXT,
                bgColor = lstColors[2],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType = 0
            )
        )
        data.add(
            Article(
                id = -2,
                title = TXT_TITLE_03,
                author = TXT_NAME_03,
                urlToImage = IMG_NEWS_07,
                authorImage = IMG_USER_03,
                content = LOREM_TEXT,
                bgColor = lstColors[0],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType = 0
            )
        )
        data.add(
            Article(
                id = -1,
                title = TXT_TITLE_04,
                author = TXT_NAME_04,
                urlToImage = IMG_NEWS_09,
                authorImage = IMG_USER_04,
                content = LOREM_TEXT,
                bgColor = lstColors[2],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType = 1
            )
        )
        data.add(
            Article(
                id = 0,
                title = TXT_TITLE_01,
                author = TXT_NAME_01,
                urlToImage = IMG_NEWS_01,
                authorImage = IMG_USER_01,
                content = LOREM_TEXT,
                bgColor = lstColors[0],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType = 1
            )
        )
        data.add(
            Article(
                id = 1,
                title = TXT_TITLE_02,
                author = TXT_NAME_02,
                urlToImage = IMG_NEWS_02,
                authorImage = IMG_USER_02,
                content = LOREM_TEXT,
                bgColor = lstColors[2],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType = 0
            )
        )
        data.add(
            Article(
                id = 2,
                title = TXT_TITLE_03,
                author = TXT_NAME_03,
                urlToImage = IMG_NEWS_03,
                authorImage = IMG_USER_03,
                content = LOREM_TEXT,
                bgColor = lstColors[0],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType = 0
            )
        )
        data.add(
            Article(
                id = 3,
                title = TXT_TITLE_04,
                author = TXT_NAME_04,
                urlToImage = IMG_NEWS_02,
                authorImage = IMG_USER_04,
                content = LOREM_TEXT,
                bgColor = lstColors[2],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType = 1
            )
        )
        data.add(
            Article(
                id = 4,
                title = TXT_TITLE_05,
                author = TXT_NAME_01,
                urlToImage = IMG_NEWS_03,
                authorImage = IMG_USER_05,
                content = LOREM_TEXT,
                bgColor = lstColors[1],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType = 1
            )
        )
        data.add(
            Article(
                id = 5,
                title = TXT_TITLE_03,
                author = TXT_NAME_01,
                urlToImage = IMG_NEWS_02,
                authorImage = IMG_USER_03,
                content = LOREM_TEXT,
                bgColor = lstColors[1],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType = 0
            )
        )
        data.add(
            Article(
                id = 6,
                title = TXT_TITLE_01,
                author = TXT_NAME_01,
                urlToImage = IMG_NEWS_01,
                authorImage = IMG_USER_01,
                content = LOREM_TEXT,
                bgColor = lstColors[2],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType = 0
            )
        )
        data.add(
            Article(
                id = 7,
                title = TXT_TITLE_01,
                author = TXT_NAME_01,
                urlToImage = IMG_NEWS_01,
                authorImage = IMG_USER_01,
                content = LOREM_TEXT,
                bgColor = lstColors[3],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType = 1
            )
        )
        data.add(
            Article(
                id = 8,
                title = TXT_TITLE_01,
                author = TXT_NAME_01,
                urlToImage = IMG_NEWS_10,
                authorImage = IMG_USER_01,
                content = LOREM_TEXT,
                bgColor = lstColors[2],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType = 1
            )
        )
        data.add(
            Article(
                id = 9,
                title = TXT_TITLE_01,
                author = TXT_NAME_01,
                urlToImage = IMG_NEWS_08,
                authorImage = IMG_USER_01,
                content = LOREM_TEXT,
                bgColor = lstColors[1],
                publishedAt = "2021-01-30T13:26:00Z",
                viewType = 0
            )
        )
        return data
    }


    private fun initListNewsImages() {
        listNewsImage.add(IMG_NEWS_01)
        listNewsImage.add(IMG_NEWS_02)
        listNewsImage.add(IMG_NEWS_03)
        listNewsImage.add(IMG_NEWS_04)
        listNewsImage.add(IMG_NEWS_05)
        listNewsImage.add(IMG_NEWS_06)
        listNewsImage.add(IMG_NEWS_07)
        listNewsImage.add(IMG_NEWS_08)
        listNewsImage.add(IMG_NEWS_09)
        listNewsImage.add(IMG_NEWS_10)
    }

    private fun initListUserImages() {
        listUserImage.add(IMG_USER_01)
        listUserImage.add(IMG_USER_02)
        listUserImage.add(IMG_USER_03)
        listUserImage.add(IMG_USER_04)
        listUserImage.add(IMG_USER_05)
    }

    private fun initListNewsTitle() {
        listNewsTitles.add(TXT_TITLE_01)
        listNewsTitles.add(TXT_TITLE_02)
        listNewsTitles.add(TXT_TITLE_03)
        listNewsTitles.add(TXT_TITLE_04)
        listNewsTitles.add(TXT_TITLE_05)
    }

    fun initListUsername() {
        listUserNames.add(TXT_NAME_01)
        listUserNames.add(TXT_NAME_02)
        listUserNames.add(TXT_NAME_03)
        listUserNames.add(TXT_NAME_04)
    }

    // news images url's for testing
    val IMG_NEWS_01 =
        "https://2.bp.blogspot.com/-ddZ2Tt8EOeo/XxtDIkHWgDI/AAAAAAAAAn0/vG13Vw5zoXU5fy_sHQ_7lW6PQz1UEXocACK4BGAYYCw/s1600/news5.PNG"
    val IMG_NEWS_02 =
        "https://4.bp.blogspot.com/-4QOyU3Q5D8c/XxtDIQ_pLmI/AAAAAAAAAns/FbocmpIje1YFxfqG5Ajln7OeJ8dX6h3wQCK4BGAYYCw/s1600/news3.PNG"
    val IMG_NEWS_03 =
        "https://1.bp.blogspot.com/-dpcd0TBJ5xk/XxtDboRBeYI/AAAAAAAAAoE/CdWFJq1k8GsGgAwGTLGJd6ToCwvtO9OtwCK4BGAYYCw/s1600/newsimg2.PNG"
    val IMG_NEWS_04 =
        "https://3.bp.blogspot.com/-Ele_lJ7t2Fg/XxtD9BfVm8I/AAAAAAAAAow/m8fpgF7Ocmcfs2rJ6nGP-Dsms5X5PQdwwCK4BGAYYCw/s1600/newsimg.png"
    val IMG_NEWS_05 =
        "https://2.bp.blogspot.com/-4eQzZxP2ubw/Xx4XnCFRANI/AAAAAAAAAps/Xwugw45_OD8rfOw_CPgbJ6455IiAspF8wCK4BGAYYCw/s1600/illust2.jpg"
    val IMG_NEWS_06 =
        "http://4.bp.blogspot.com/-aisXccEBqJY/Xx37Zdf7wMI/AAAAAAAAApg/8mbSFn0JvrIdIIRJrxoaU7GH0wsBOgCsACK4BGAYYCw/s640/illustration.jpg"
    val IMG_NEWS_07 =
        "https://cdn.dribbble.com/users/1663335/screenshots/13906863/media/f82fca5285ba7260e7408cff9edb3fa7.jpg"
    val IMG_NEWS_08 =
        "http://4.bp.blogspot.com/-aisXccEBqJY/Xx37Zdf7wMI/AAAAAAAAApg/8mbSFn0JvrIdIIRJrxoaU7GH0wsBOgCsACK4BGAYYCw/s640/illustration.jpg"
    val IMG_NEWS_09 =
        "https://cdn.dribbble.com/users/2400016/screenshots/13897147/media/2e54a3ade13ebb2611c999e4178c133f.png"
    val IMG_NEWS_10 =
        "https://cdn.dribbble.com/users/2400016/screenshots/11466370/image.png"

    var listNewsImage: MutableList<String> = ArrayList()

    // user images for testing
    val IMG_USER_01 =
        "https://2.bp.blogspot.com/-6EcFUPmzExo/XxtD9BbEO4I/AAAAAAAAAo0/n-AxAZrAVLQBbzjcKhkIOHtSLixVUz0lgCK4BGAYYCw/s400/user3.png"
    val IMG_USER_02 =
        "https://2.bp.blogspot.com/-R0rfeBv6PbA/XxtD75IBizI/AAAAAAAAAoU/xgUu9IuGwVcwpnihSXMNSZ9YhiNrIpTuwCK4BGAYYCw/s400/user4.png"
    val IMG_USER_03 =
        "https://1.bp.blogspot.com/-7cV7-_0mgv8/XxtD9IRzJBI/AAAAAAAAAo4/WaMt1T9cfXgn1qGmnYa3oWGUEW2IQUbmACK4BGAYYCw/s400/user2.png"
    val IMG_USER_04 =
        "https://cdn.dribbble.com/users/2400016/avatars/normal/401c4be556cfced8004233dad4afdd98.jpg?1592492657"
    val IMG_USER_05 =
        "https://1.bp.blogspot.com/-crUZwpqquAo/XxtD7_lwqEI/AAAAAAAAAoY/TbRYnR82uk8LXrQpx-tsBA4-KyFISSFUgCK4BGAYYCw/s400/user.png"


    var listUserImage: MutableList<String> = ArrayList()


    // user titles for testing
    val TXT_TITLE_01 = "Stack Overflow - Where Developers Learn, Share, and Build"
    val TXT_TITLE_02 = "Book About Stars"
    val TXT_TITLE_03 = "Design A Simple UI Screen in Flare"
    val TXT_TITLE_04 = "Naija-based designer making stuff with Studio"
    val TXT_TITLE_05 = "How To Write Better Resume"


    var listNewsTitles: MutableList<String> = ArrayList()


    // user names for testing
    val TXT_NAME_01 = "Jona Dinges"
    val TXT_NAME_02 = "Invision Studio"
    val TXT_NAME_03 = "Benoit Drigny"
    val TXT_NAME_04 = "Ada Vishneva"

    var listUserNames: MutableList<String> = ArrayList()


    // News content for testing
    val LOREM_TEXT =
        "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book. It usually begins with: The purpose of lorem ipsum is to create a natural looking block of text (sentence, paragraph, page, etc.) that doesn't distract from the layout. A practice not without controversy, laying out pages with meaningless filler text can be very useful when the focus is meant to be on design, not content."

    // news background colors
    val lstColors =
        arrayOf("RED", "YELLOW", "BLACK", "PURPLE")


    /**
     * this method generate a random news item
     */
    fun generateRandomArticle(): Article? {
        return Article(
            id = -1,
            title = getRandomNewsTitle(),
            author = getRandomUsername(),
            urlToImage = getRandomNewsImage(),
            authorImage = getRandomUserImage(),
            content = getRandomContent(),
            bgColor = getRandomBgColor(),
            publishedAt = "2021-01-30T13:26:00Z",
            viewType = 0
        )
    }

    // generate a random string title
    private fun getRandomNewsTitle(): String? {
        if (listNewsTitles.isNullOrEmpty())
            return "Stack Overflow - Where Developers Learn, Share, and Build"
        val index = Random.nextInt(0, listNewsTitles.size - 1)
        return listNewsTitles[index]
    }

    // generate a random news image url string
    private fun getRandomNewsImage(): String? {
        if (listNewsImage.isNullOrEmpty())
            return "https://2.bp.blogspot.com/-ddZ2Tt8EOeo/XxtDIkHWgDI/AAAAAAAAAn0/vG13Vw5zoXU5fy_sHQ_7lW6PQz1UEXocACK4BGAYYCw/s1600/news5.PNG"
        val index = Random.nextInt(0, listNewsImage.size-1)
        return listNewsImage[index]
    }

    // generate a random news image url string
    private fun getRandomUserImage(): String? {
        if (listUserImage.isNullOrEmpty())
            return "https://2.bp.blogspot.com/-6EcFUPmzExo/XxtD9BbEO4I/AAAAAAAAAo0/n-AxAZrAVLQBbzjcKhkIOHtSLixVUz0lgCK4BGAYYCw/s400/user3.png"
        val index = Random.nextInt(0, listUserImage.size-1)
        return listUserImage[index]
    }

    // generate a random String Content
    private fun getRandomContent(): String? {
        return LOREM_TEXT
    }

    // generate a random String Content
    private fun getRandomUsername(): String? {
        if (listUserNames.isNullOrEmpty())
            return "Jona Dinges"
        val index = Random.nextInt(0, listUserNames.size-1)
        return listUserNames[index]
    }

    // generate a random news background color
    private fun getRandomBgColor(): String? {
        val index = Random.nextInt(0, lstColors.size-1)
        return lstColors[index]
    }

    // generate random date
    private fun getRandompublishedAt() :String? {
        return "2021-01-30T13:26:00Z"
    }


    // generate a viewtype based on the index and the list size
    // this specify the view grid system of the format of the news system list

    // generate a viewtype based on the index and the list size
    // this specify the view grid system of the format of the news system list
    private fun generateViewType(position: Int): Int {
        if (position == 0) {
            return 1
        } else if (position == 1) {
            return 0
        }
        if (position != 0) {
            val ir = position / 2 + 1
            Log.e("TAG", "generateViewType: $ir")
            return if (ir % 2 == 0) {
                if (position % 2 == 0) {
                    0
                } else 1
            } else {
                if (position % 2 == 0) {
                    1
                } else 0
            }
        }
        return 0
    }

}