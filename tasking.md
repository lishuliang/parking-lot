parking director


迭代五：
多个停车场，parking manager，不同的parking boy
1.given：空余位置相同的停车场、车 when：parking manager停车 then：停车在顺序靠前的停车场
2.given：已停车 when：parking manager取车 then：取车成功
3.given：车 when：parking manager指定有效的parking boy停车 then：停车成功
4.given：车 when：parking manager指定无效的parking boy停车 then：停车失败
5.given：已停车 when：parking manager指定有效的parking boy取车 then：取车成功
6.given：已停车 when：parking manager指定无效的parking boy取车 then：取车失败
7.given：停车场已满 when：停车 then：停车失败
8.given：无效ticket when：取车 then：取车失败


迭代四：
多个停车场， super parking boy
1.given：空车率不同的停车场、车 when：super parking boy停车 then：停车在空车率最多的停车场
2.given：空车率相同的停车场、车 when：super parking boy停车 then：停车在顺序在前面的停车场
3.given：多个已满停车场、车 when：super parking boy停车 then：停车失败
4.given：已停车在停车场、ticket when：super parking boy取车 then：取车成功



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
