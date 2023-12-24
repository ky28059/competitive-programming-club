package UC

val x:(String)->String=
{val r="######\n".repeat(6).toCharArray()
var i=1
for((x,y) in it.split("\n").map{it.split(",")})r[x.toInt()*7+y.toInt()]=(""+i++)[0]
String(r)}


fun main() {
    println(x("2,3\n1,1\n0,2"))
    println("""{val r="######\n".repeat(6).toCharArray() 
var i=1
for((x,y) in it.split("\n").map{it.split(",")})r[x.toInt()*7+y.toInt()]=(""+i++)[0]
String(r)}""".length)
}
