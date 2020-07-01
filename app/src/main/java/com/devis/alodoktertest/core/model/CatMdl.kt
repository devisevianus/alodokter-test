package com.devis.alodoktertest.core.model

import java.io.Serializable

/**
 * Created by devis on 01/07/20
 */

class CatsMdl : Serializable {
    private var listCat: List<CatMdl> = listOf(
        CatMdl(
            "Persia",
            "https://scontent-lax3-1.cdninstagram.com/v/t51.2885-19/s150x150/22637510_141328466502777_8607014027668750336_n.jpg?_nc_ht=scontent-lax3-1.cdninstagram.com&_nc_ohc=YDBqdHUMhn0AX8mOkQw&oh=9b99eacbae0be2c020d7495d5cb02215&oe=5F1B6C6D",
            getListPersia()
        ),
        CatMdl(
            "Bengal",
            "https://i.pinimg.com/originals/ab/b4/05/abb4052a01dd6c615ebf2e7896018396.jpg",
            getListBengal()
        ),
        CatMdl(
            "Scottish Fold",
            "https://www.thehappycatsite.com/wp-content/uploads/2016/11/sf-feature-150x150.jpg",
            getListScottishFold()
        ),
        CatMdl(
            "Munchkin",
            "https://i.pinimg.com/150x150/39/23/7d/39237d6b9d0455111fc0fc14e83a741f.jpg",
            getListMunchkin()
        )
    )

    private fun getListPersia(): List<CatTypeMdl> {
        return listOf(
            CatTypeMdl(
                "Persia 1",
                "https://scontent-lax3-1.cdninstagram.com/v/t51.2885-19/s150x150/22637510_141328466502777_8607014027668750336_n.jpg?_nc_ht=scontent-lax3-1.cdninstagram.com&_nc_ohc=YDBqdHUMhn0AX8mOkQw&oh=9b99eacbae0be2c020d7495d5cb02215&oe=5F1B6C6D"
            ),
            CatTypeMdl(
                "Persia 2",
                "https://ultimatehomelife.com/wp-content/uploads/2017/07/Best-Cat-Food-For-Persian-Cats-150x150.jpg"
            ),
            CatTypeMdl(
                "Persia 3",
                "https://i.pinimg.com/originals/9d/77/93/9d77938e62b3e47b5fd8c94e6ba46bad.jpg"
            )
        )
    }

    private fun getListBengal(): List<CatTypeMdl> {
        return listOf(
            CatTypeMdl(
                "Bengal 1",
                "https://i.pinimg.com/originals/ab/b4/05/abb4052a01dd6c615ebf2e7896018396.jpg"
            ),
            CatTypeMdl(
                "Bengal 2",
                "https://i.pinimg.com/originals/9c/bc/d1/9cbcd1c710b86ed9bd58639b86ebf100.jpg"
            ),
            CatTypeMdl(
                "Bengal 3",
                "https://i.pinimg.com/originals/fb/b7/14/fbb714821c2203588f24513d1ab69298.jpg"
            )
        )
    }

    private fun getListScottishFold(): List<CatTypeMdl> {
        return listOf(
            CatTypeMdl(
                "Scottish Fold 1",
                "https://www.thehappycatsite.com/wp-content/uploads/2016/11/sf-feature-150x150.jpg"
            ),
            CatTypeMdl(
                "Scottish Fold 2",
                "https://i.pinimg.com/originals/e4/f8/b7/e4f8b7f3cc2c85519963a378f1deaa8e.png"
            ),
            CatTypeMdl(
                "Scottish Fold 3",
                "https://i.pinimg.com/236x/a3/11/74/a31174d9133bbe4382566d283d3a2282--scottish-animals-scottish-fold-kittens.jpg"
            )
        )
    }

    private fun getListMunchkin(): List<CatTypeMdl> {
        return listOf(
            CatTypeMdl(
                "Munchkin 1",
                "https://i.pinimg.com/150x150/39/23/7d/39237d6b9d0455111fc0fc14e83a741f.jpg"
            ),
            CatTypeMdl(
                "Munchkin 2",
                "https://i.pinimg.com/236x/1c/a5/66/1ca566d817652f309dc4ecaa7eda7b6c--instagram-ps.jpg"
            ),
            CatTypeMdl(
                "Munchkin 3",
                "https://www.kittenswhiskers.com/wp-content/uploads/sites/23/2014/05/munchkin-kitteh-150x150.jpg"
            )
        )
    }

    fun getAllCats(): List<CatMdl> {
        return listCat
    }
}

data class CatMdl(
    var name: String,
    var url: String,
    var listCatType: List<CatTypeMdl>
) : Serializable

data class CatTypeMdl(
    val name: String,
    val url: String
) : Serializable