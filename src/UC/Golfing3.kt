package UC

fun y(a:Int,b:Int,c:Int,z:String)
{val d=mutableMapOf("." to 0)
val e=z.split("\n").map{it.split(" ")}
var v=b
fun MutableMap<String, Int>.f()=this.filter{it.value>=c/(b+1.0)}
fun h(f:String)=if(d[f]!=null)d[f]=d[f]!!+1 else d[f]=1
e.forEach{h(it[0])}
val w=d.f().toMutableMap()
while(w.size>b)w.remove(w.minByOrNull{it.value}!!.key)
e.forEach{if(it[0]in w)h(it[1])}
var n=d.f()
while(n.size<b-w.size){val l=d.minByOrNull{it.value}!!.key
e.forEach{if(it[0]==l)h(it[1])}
d.remove(l)
n=d.f()}
w.forEach{print(it.key+" ");v--}
while(v-->0)print(n.filter{it.key!in w}.maxByOrNull{it.value}!!.key+" ")}


fun main() {
    y(4, 1, 5, """
A B C D
A B C D
B A C D
B A C D
C D A B
    """.trimIndent())
    println()
    println("""{val d=mutableMapOf("." to 0)
val e=z.split("\n").map{it.split(" ")}
var v=b
fun MutableMap<String, Int>.f()=this.filter{it.value>=c/(b+1.0)}
fun h(f:String)=if(d[f]!=null)d[f]=d[f]!!+1 else d[f]=1
e.forEach{h(it[0])}
val w=d.f().toMutableMap()
while(w.size>b)w.remove(w.minByOrNull{it.value}!!.key)
e.forEach{if(it[0]in w)h(it[1])}
var n=d.f()
while(n.size<b-w.size){val l=d.minByOrNull{it.value}!!.key
e.forEach{if(it[0]==l)h(it[1])}
d.remove(l)
n=d.f()}
w.forEach{print(it.key+" ");v--}
while(v-->0)print(n.filter{it.key!in w}.maxByOrNull{it.value}!!.key+" ")}""".length)
}
