迭代三：
多个停车场，smart parking boy
1.given：空余位置不同的停车场、车 when：smart parking boy停车 then：停车在空余位置最多的停车场
2.given：空余位置相同的停车场、车 when：smart parking boy停车 then：停车在顺序在前面的停车场
3.given：多个已满停车场、车 when：smart parking boy停车 then：停车失败
4.given：已停车在停车场、ticket when：smart parking boy取车 then：取车成功



迭代二：
多个停车场，parking boy
1.given：车 when：parking boy停车在第一个停车场（未满）then：停车成功
2.given：已在停车场停车 when：parking boy取车 then：取车成功
3.given：车 when：parking boy停车在第二个停车场（第一个已满）then：停车成功
4.given：车 when：所有停车场都停满 then：停车失败
5.given：车 when： then：




迭代一：
1.given：车 when：停车（有空位） then：停车成功
2.given：已停车 when：取车 then：取车成功
3.given：未停车 when：取车 then：取车失败
4.given：车 when：停车（没有空位） then：停车失败
