// TODO: rather nasty
function romanToInt(s: string): number {
    const [, thousands, nineHundred, fiveHundred, fourHundred, hundreds, ninety, fifty, forty, tens, nine, five, four, ones] = s.match(/(M*)((?:CM)?)(D?)((?:CD)?)(C*)((?:XC)?)(L?)((?:XL)?)(X*)((?:IX)?)(V?)((?:IV)?)(I*)/);
    return thousands.length * 1000
        + hundreds.length * 100 + (nineHundred.length && 900) + (fiveHundred.length && 500) + (fourHundred.length && 400)
        + tens.length * 10 + (ninety.length && 90) + (fifty.length && 50) + (forty.length && 40)
        + ones.length + (nine.length && 9) + (five.length && 5) + (four.length && 4)
}
