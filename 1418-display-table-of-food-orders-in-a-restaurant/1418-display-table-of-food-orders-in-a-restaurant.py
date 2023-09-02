class Solution:
    def displayTable(self, orders: List[List[str]]) -> List[List[str]]:
        table_orders = {}
        menu_items = set()
        
        for order in orders:
            num = order[1]
            if num not in table_orders:
                table_orders[num] = {}
            items = table_orders[num]
            dish = order[2]
            items[dish] = 1 + items.get(dish, 0)
            menu_items.add(dish)
        menu_items = sorted(menu_items)
        res = [["Table"] + [item for item in menu_items]]
        rows = []
        for table, ordered in table_orders.items():
            rows.append([int(table)] + [str(ordered.get(item, 0)) for item in menu_items])
        rows.sort()
        for row in rows:
            row[0] = str(row[0])
        return res + rows
        