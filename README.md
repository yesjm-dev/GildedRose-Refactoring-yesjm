# 코드 리팩토링 스터디 🔨
커리어리를 둘러보다 [리팩토링 해보실? 지금 당장 도전해보세요!](https://careerly.co.kr/comments/90308?utm_campaign=user-share) 라는 글을 보고 도전하게 되었습니다.

TDD의 길은 아직 멀고도 험하네요.

# Gilded Rose 요구사항 명세

안녕하세요, **Gilded Rose**에 오신 것을 환영합니다. 우리는 도시의 주요 지역에있는 작은 숙소(상점)이며, **Allison**(앨리슨)이라는 상냥한 사람이 운영하고 있습니다.

우리는 최고의 제품만을 구입하여 판매하고 있습니다. 불행히도, 상품 판매 기한이 가까워 질수록 품질이 저하되어가고 있습니다.

우리는 재고를 업데이트하는 시스템이 있습니다. 이 시스템은 지금은 새로운 모험을 떠나고 없는 **Leeroy**(리로이)라는 빡빡한 성격의 인물에 의해 개발되었습니다. 

당신이 할 일은 시스템에 새로운 기능을 추가하여, 새로운 카테고리의 상품을 판매할 수 있도록하는 것입니다.

## 시스템 소개
먼저 시스템을 소개합니다.

- 모든 아이템은 `SellIn` 값을 가지며, 이는 아이템을 판매해야하는 (남은) 기간을 나태냅니다.
- 모든 아이템은 `Quality` 값을 가지며, 이것은 아이템의 가치를 나타냅니다.
- 하루가 지날때마다, 시스템은 두 값(`SellIn`, `Quality`)을 *1* 씩 감소시킵니다.

간단하죠? 흥미로운 부분은 지금부터입니다.

- 판매하는 나머지 일수가 없어지면, `Quality` 값은 **2배**로 떨어집니다.
- `Quality` 값은 결코 음수가 되지는 않습니다.
- "**Aged Brie**"(오래된 브리치즈)은(는) 시간이 지날수록 `Quality` 값이 올라갑니다.
- `Quality` 값은 50를 초과 할 수 없습니다.
- `Sulfuras`는 전설의 아이템이므로, 반드시 판매될 필요도 없고 `Quality` 값도 떨어지지 않습니다.
- "**Backstage passes**(백스테이지 입장권)"는 "**Aged Brie**"와 유사하게 `SellIn` 값에 가까워 질수록 `Quality` 값이 상승하고, **10일 부터는** 매일 *2* 씩 증가하다, **5일 부터는**이 되면 매일 *3* 씩 증가하지만, 콘서트 종료 후에는 *0*으로 떨어집니다.

## 시스템 업데이트 요구 사항

최근 "**Conjured**"(마법에 걸린) 상품 공급 업체와 계약했습니다. 따라서 시스템의 업데이트가 필요합니다.

- "**Conjured**" 아이템은 일반 아이템의 2배의 속도로 품질(`Quality`)이 저하됩니다.

모든 것이 제대로 작동하는 한에서는 `UpdateQuality()` 메서드를 변경하거나 새로운 코드의 추가를 자유롭게 할 수 있습니다. 그러나 `Item` 클래스와 `Items` 속성은 변경하지 마세요.

이것들은 저기 구석에있는 고블린의 것이고, 그 친구는 코드의 공유 소유권을 믿지 않기 때문에, 미친듯이 화를 내며(insta-rage) 여러분에게 한 방(one-shot)을 날릴 수도 있습니다. (`UpdateQuality()` 메서드와 `Items` 속성을 정적(static)으로 만드는 것은 괜찮습니다. 저희가 책임질게요.)

다시 한 번 확인하자면, 아이템의 `Quality`는 50 이상으로 증가할 수는 없습니다. 하지만 `Sulfuras`는 전설의 아이템이기 때문에 `Quality` 값은 80이며, 값이 바뀌지 않습니다.

# Gilded Rose Refactoring Kata

You can find out more about this exercise in my YouTube video [Why Developers LOVE The Gilded Rose Kata](https://youtu.be/Mt4XpGxigT4).

I use this kata as part of my work as a technical coach. I wrote a lot about the coaching method I use in this book [Technical Agile Coaching with the Samman method](https://leanpub.com/techagilecoach). A while back I wrote this article ["Writing Good Tests for the Gilded Rose Kata"](http://coding-is-like-cooking.info/2013/03/writing-good-tests-for-the-gilded-rose-kata/) about how you could use this kata in a [coding dojo](https://leanpub.com/codingdojohandbook).


## How to use this Kata

The simplest way is to just clone the code and start hacking away improving the design. You'll want to look at the ["Gilded Rose Requirements"](https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/main/GildedRoseRequirements.txt) which explains what the code is for. I strongly advise you that you'll also need some tests if you want to make sure you don't break the code while you refactor.

You could write some unit tests yourself, using the requirements to identify suitable test cases. I've provided a failing unit test in a popular test framework as a starting point for most languages.

Alternatively, use the Approval tests provided in this repository. (Read more about that in the section "Text-based Approval Testing").

The idea of the exercise is to do some deliberate practice, and improve your skills at designing test cases and refactoring. The idea is not to re-write the code from scratch, but rather to practice taking small steps, running the tests often, and incrementally improving the design. 

Please don't send me a pull request with your solution. It can be a bit confusing since GitHub encourages you to do so! Please only send me pull requests if you have a correction or improvement to the starting position. You don't want to spoil the fun of doing the exercise for other people!


### Gilded Rose Requirements in other languages 

- [English](GildedRoseRequirements.txt)
- [Español](GildedRoseRequirements_es.md)
- [Français](GildedRoseRequirements_fr.md)
- [Italiano](GildedRoseRequirements_it.md)
- [日本語](GildedRoseRequirements_jp.md)
- [Português](GildedRoseRequirements_pt-BR.md)
- [Русский](GildedRoseRequirements_ru.txt)
- [ไทย](GildedRoseRequirements_th.md)
- [中文](GildedRoseRequirements_zh.txt)
- [한국어](GildedRoseRequirements_kr.md)
- [German](GildedRoseRequirements_de.md)

## Text-Based Approval Testing

Most language versions of this code have a [TextTest](https://texttest.org) fixture for Approval testing. For information about this, see the [TextTests README](https://github.com/emilybache/GildedRose-Refactoring-Kata/tree/main/texttests)

## History of the exercise

This Kata was originally created by Terry Hughes (http://twitter.com/TerryHughes). It is already on GitHub [here](https://github.com/NotMyself/GildedRose). See also [Bobby Johnson's description of the kata](https://iamnotmyself.com/refactor-this-the-gilded-rose-kata/).

I translated the original C# into a few other languages, (with a little help from my friends!), and slightly changed the starting position. This means I've actually done a small amount of refactoring already compared with the original form of the kata, and made it easier to get going with writing tests by giving you one failing unit test to start with. I also added test fixtures for Text-Based approval testing with TextTest (see [the TextTests](https://github.com/emilybache/GildedRose-Refactoring-Kata/tree/main/texttests))

As Bobby Johnson points out in his article ["Why Most Solutions to Gilded Rose Miss The Bigger Picture"](https://iamnotmyself.com/why-most-solutions-to-gilded-rose-miss-the-bigger-picture/), it'll actually give you
better practice at handling a legacy code situation if you do this Kata in the original C#. However, I think this kata
is also really useful for practicing writing good tests using different frameworks and approaches, and the small changes I've made help with that. I think it's also interesting to compare what the refactored code and tests look like in different programming languages.

## Translating this code

More translations are most welcome! I'm very open for pull requests that translate the starting position into additional languages. 

Please note a translation should ideally include:

- a translation of the production code for 'update_quality' and Item
- one failing unit test complaining that "fixme" != "foo"
- a TextTest fixture, ie a command-line program that runs update_quality on the sample data for the number of days specified.

Please don't write too much code in the starting position or add too many unit tests. The idea with the one failing unit test is to tempt people to work out how to fix it, discover it wasn't that hard, and now they understand what this test is doing they realize they can improve it.  

If your programming language doesn't have an easy way to add a command-line interface, then the TextTest fixture is probably not necessary.

