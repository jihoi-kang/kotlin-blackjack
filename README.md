# kotlin-blackjack

## step2
블랙잭 게임을 변형한 프로그램을 구현한다. 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.

### requirements
- [x] 카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다
- [x] 게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다(21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다)

## step3

### requirements
- [x] 딜러는 처음에 받은 2장의 합계가 16이하이면 반드시 1장의 카드를 추가로 받아야 하고, 17점 이상이면 추가로 받을 수 없다.
- [x] 딜러가 21을 초과하면 그 시점까지 남아 있던 플레이어들은 가지고 있는 패에 상관 없이 승리한다.
- [x] 게임을 완료한 후 각 플레이어별로 승패를 출력한다.
- [x] 딜러의 카드 중 하나는 비공개이며 모든 참가자의 차례가 끝나면 공개된다
- [x] 플레이어의 턴에서 21이 되면(블랙잭) 더 이상 해당 플레이어에게 카드를 받지 않고 다음 턴으로 넘어가야 한다
