Goole OA problem: 
Leetcode 681, 683
1. Email处理。 email地址分为local@domain。（1）local里dots('.') between some characters 要去除。
2）local里如果有'+'，'+'和后面的全去除。比如'a.b@example.com' -> 'ab@example.com', 'dupli......cate@example.com'
 -> 'duplicate@example.com',  'd.u.p.l.i.c.a.t.e@example.com' -> 'duplicate@example.com',  'ab+work@example.com' 
 -> 'ab@example.com'。处理完后的邮件地址一样的放在一组，
返回所有组，里面不止一个邮件地址的组的个数。

lc159
2. 采水果。小红去果园采水果。有2个篮子，可以装无数个水果，但是只能装一种水果。从任意位置的树开始，往右采。遇到2种情况退出，
1. 遇到第三种水果，没有篮子可以放了，2. 到头了。返回可以采摘的最多的水果个数。 比如[1,2,1,3,4,3,5,1,2] return 3。[1,2,1,2,1,2,1] return 7


1. store and house
   这题给你两个 array, 都是一维的，而是都是int
   int houses[]  and int stores[], 分别代表各house/store 的location.
   让你找出每个houses 最近的 stores。. 牛人云集,一亩三分地
   return 一个int array[], index = houses index, value = 最近的stores的location
   !!!注意： 可以有多个stores 或 houses 的location都相同。
                 也想想如果两个都是空集怎么办，虽然题目没有写，但是自己要考虑到吧。. Waral 博客有更多文章,
   比如： house＝ ［2，6，12，18］
              store ＝  ［5， 8， 9 ， 20］
     return result ＝ ［5，5，9，20］ 
    因为house［0］ ＝ 2， 与store［0］＝ 5 最近， 因此类推

   我的做法：sort stores［］ + binary search（返回离house最近的store）
   o(nlogn + nlogn)

2. tree ancestor 
   给你一个array［］， 每一个element存的是它parents的位置。. 1point 3acres 论坛
  给你一个distance n, 是一个 int, 让你 return 一个array，表示每个element与它n距离的ancestor
  具体的题目， 大家可以找找之前的帖子，有人有详细描述。
  这里我具体说一下 题目有个细节：给你的这个array的第一个element 一定是－1（代表这个element就是root）
  不知道这样是否能有更好的解法？
  我就是暴力解，travel每一个element， 然后去找它的ancestor o(m*n);

  如果有好的解法，分享一下？. 牛人云集,一亩三分地