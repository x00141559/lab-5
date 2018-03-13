
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._
/*1.2*/import models.products.Category
/*2.2*/import models.products.Product
/*3.2*/import models.users.User

object listProducts extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[List[Product],List[Category],Long,String,User,play.api.Environment,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(products: List[Product], categories: List[Category], catId: Long, filter: String,user: User,env: play.api.Environment):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.121*/("""


"""),_display_(/*7.2*/main("Products",user)/*7.23*/ {_display_(Seq[Any](format.raw/*7.25*/("""
  """),_display_(/*8.4*/if(flash.containsKey("error"))/*8.34*/ {_display_(Seq[Any](format.raw/*8.36*/("""
    """),format.raw/*9.5*/("""<p class="alert alert-warning">
        """),_display_(/*10.10*/flash/*10.15*/.get("error")),format.raw/*10.28*/("""
    """),format.raw/*11.5*/("""</p>
""")))}),format.raw/*12.2*/("""

"""),format.raw/*14.1*/("""<p class="lead">Product Catalogue</p>
<br>
<div class="row">
  <div class="col-sm-2">
    <h4>Categories</h4>
    <div class="list-group">
      <a href=""""),_display_(/*20.17*/routes/*20.23*/.ProductCtrl.listProducts(0, filter)),format.raw/*20.59*/("""" class="list-group-item">All Categories</a>
      """),_display_(/*21.8*/for(c <- categories) yield /*21.28*/ {_display_(Seq[Any](format.raw/*21.30*/("""
        """),format.raw/*22.9*/("""<a href=""""),_display_(/*22.19*/routes/*22.25*/.ProductCtrl.listProducts(c.getId, filter)),format.raw/*22.67*/("""" class="list-group-item">"""),_display_(/*22.94*/c/*22.95*/.getName),format.raw/*22.103*/("""
          """),format.raw/*23.11*/("""<span class="badge">"""),_display_(/*23.32*/c/*23.33*/.getProducts.size()),format.raw/*23.52*/("""</span>
        </a>
      """)))}),format.raw/*25.8*/("""
    """),format.raw/*26.5*/("""</div>
  </div>
  <div class="col-sm-10">
      """),_display_(/*29.8*/if(flash.containsKey("success"))/*29.40*/ {_display_(Seq[Any](format.raw/*29.42*/("""
        """),format.raw/*30.9*/("""<div class="alert alert-success">
          """),_display_(/*31.12*/flash/*31.17*/.get("success")),format.raw/*31.32*/("""
        """),format.raw/*32.9*/("""</div>
      """)))}),format.raw/*33.8*/("""

      			"""),format.raw/*35.10*/("""<!-- Search Form -->
			<div id="actions">
        <form action=""""),_display_(/*37.24*/routes/*37.30*/.ProductCtrl.listProducts(catId)),format.raw/*37.62*/("""" method="GET">
         <input type="search" id="searchbox" name="filter" value=""""),_display_(/*38.68*/filter),format.raw/*38.74*/("""" placeholder="Filter by product name...">
         <input type="submit" id="searchsubmit" value="Filter by name" class="btn-md btn-primary">
        </form>
       </div>
    <table class="table table-bordered table-hover table-condensed">   
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Description</th>
          <th>Stock</th>
          <th>Price</th>   
        </tr>
      </thead>

      <tbody>
        """),_display_(/*54.10*/for(p<-products) yield /*54.26*/ {_display_(Seq[Any](format.raw/*54.28*/("""
          """),format.raw/*55.11*/("""<tr>
              """),_display_(/*56.16*/if(env.resource("public/images/productImages/thumbnails/" + p.getId + ".jpg").isDefined)/*56.104*/ {_display_(Seq[Any](format.raw/*56.106*/("""
                """),format.raw/*57.17*/("""<td><img src="/assets/images/productImages/thumbnails/"""),_display_(/*57.72*/(p.getId + ".jpg")),format.raw/*57.90*/(""""/></td>
            """)))}/*58.15*/else/*58.20*/{_display_(Seq[Any](format.raw/*58.21*/("""
                """),format.raw/*59.17*/("""<td><img src="/assets/images/productImages/thumbnails/noImage.jpg"/></td>
            """)))}),format.raw/*60.14*/("""
            """),format.raw/*61.13*/("""<td class="numeric">"""),_display_(/*61.34*/p/*61.35*/.getId),format.raw/*61.41*/("""</td>
            <td><a href=""""),_display_(/*62.27*/routes/*62.33*/.ProductCtrl.productDetails(p.getId)),format.raw/*62.69*/("""">
                """),_display_(/*63.18*/p/*63.19*/.getName),format.raw/*63.27*/("""</td>
               </a>     
            <td>"""),_display_(/*65.18*/p/*65.19*/.getDescription),format.raw/*65.34*/("""</td>
            <td  class="numeric">"""),_display_(/*66.35*/p/*66.36*/.getStock),format.raw/*66.45*/("""</td>
            <td  class="numeric">€ """),_display_(/*67.37*/("%.2f".format(p.getPrice))),format.raw/*67.64*/("""</td>
            <td><a href=""""),_display_(/*68.27*/routes/*68.33*/.ShoppingCtrl.addToBasket(p.getId)),format.raw/*68.67*/(""""  class="btn btn-default btn-xs"><span class="glyphicon glyphicon-shopping-cart"></span></a></td>

          </tr>
        """)))}),format.raw/*71.10*/("""
      """),format.raw/*72.7*/("""</tbody>

    </table>
  </div>
</div>
""")))}))
      }
    }
  }

  def render(products:List[Product],categories:List[Category],catId:Long,filter:String,user:User,env:play.api.Environment): play.twirl.api.HtmlFormat.Appendable = apply(products,categories,catId,filter,user,env)

  def f:((List[Product],List[Category],Long,String,User,play.api.Environment) => play.twirl.api.HtmlFormat.Appendable) = (products,categories,catId,filter,user,env) => apply(products,categories,catId,filter,user,env)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Mar 13 16:09:18 GMT 2018
                  SOURCE: /home/wdd/webapps/lab5/app/views/listProducts.scala.html
                  HASH: 28c9ee62ae3dda22c8b4d2011bf469cccd4f2a6b
                  MATRIX: 651->1|690->34|728->66|1124->92|1339->211|1368->215|1397->236|1436->238|1465->242|1503->272|1542->274|1573->279|1641->320|1655->325|1689->338|1721->343|1757->349|1786->351|1968->506|1983->512|2040->548|2118->600|2154->620|2194->622|2230->631|2267->641|2282->647|2345->689|2399->716|2409->717|2439->725|2478->736|2526->757|2536->758|2576->777|2634->805|2666->810|2741->859|2782->891|2822->893|2858->902|2930->947|2944->952|2980->967|3016->976|3060->990|3099->1001|3192->1067|3207->1073|3260->1105|3370->1188|3397->1194|3878->1648|3910->1664|3950->1666|3989->1677|4036->1697|4134->1785|4175->1787|4220->1804|4302->1859|4341->1877|4382->1900|4395->1905|4434->1906|4479->1923|4597->2010|4638->2023|4686->2044|4696->2045|4723->2051|4782->2083|4797->2089|4854->2125|4901->2145|4911->2146|4940->2154|5015->2202|5025->2203|5061->2218|5128->2258|5138->2259|5168->2268|5237->2310|5285->2337|5344->2369|5359->2375|5414->2409|5570->2534|5604->2541
                  LINES: 24->1|25->2|26->3|31->4|36->4|39->7|39->7|39->7|40->8|40->8|40->8|41->9|42->10|42->10|42->10|43->11|44->12|46->14|52->20|52->20|52->20|53->21|53->21|53->21|54->22|54->22|54->22|54->22|54->22|54->22|54->22|55->23|55->23|55->23|55->23|57->25|58->26|61->29|61->29|61->29|62->30|63->31|63->31|63->31|64->32|65->33|67->35|69->37|69->37|69->37|70->38|70->38|86->54|86->54|86->54|87->55|88->56|88->56|88->56|89->57|89->57|89->57|90->58|90->58|90->58|91->59|92->60|93->61|93->61|93->61|93->61|94->62|94->62|94->62|95->63|95->63|95->63|97->65|97->65|97->65|98->66|98->66|98->66|99->67|99->67|100->68|100->68|100->68|103->71|104->72
                  -- GENERATED --
              */
          