<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
	<section id="wrapper">
		<article>
			<header id="second_header">
				<hgroup>
					<h1><mark>버거킹</mark> 주문 화면</h1>
					<h2>상품과 수량을 선택해주세요</h2>
				</hgroup>
			</header>
		</article>	
		<form id="order_form" action="result.jsp" style = "width : 450px; margin: 0 auto;">	
	<!-- 넘겨줄 값 없을때는 division, 있을때는 form action으로 묶자 -->
			<article>
			<table>
				<tr>
					<td>
						<figure>
							<img src="../../img/burger.png" alt="햄버거"
								style="width: 150px; height: 150px" /><br/>
							<figcaption>
								<input type="checkbox" name="hamburger-menu" value="hamburger"/>￦5,500
								<input type="number" name="hamburger-count" style="width: 30px;" min="1" max="9" />개
							</figcaption>
						</figure>
					</td>
					<td>
						<figure>
						<img src="../../img/bagel.jpg" alt="베이글"
							style="width: 150px; height: 150px" /><br/>
						<figcaption>
						<input type="checkbox" name="bagel-menu" value="bagel"/>
							￦4,000
						<input type="number" name="bagel-count" style="width: 30px" min="0" max="9"/> 개
						</figcaption>
						</figure>
					</td>
					<td>
						<figure>
						<img src="../../img/chip.jpg" alt="감자칩"
							style="width: 150px; height: 150px" /><br/>
						<figcaption>
						<input type="checkbox" name="chip-menu" value="chip"/>
							￦1,000
						<input type="number" name="chip-count" style="width: 30px" min="0" max="9"/> 개
						</figcaption>						
						</figure>
					</td>
				</tr>
				<tr>
					<td>
					<figure>
						<img src="../../img/salad.jpg" alt="샐러드"
							style="width: 150px; height: 150px" /><br/>
					<figcaption>
						<input type="checkbox" name="salad-menu" value="salad"/>
							￦3,000
						<input type="number" name="salad-count" style="width: 30px" min="0" max="9"/> 개
					</figcaption>
					</figure>
					</td>
					<td>
						<figure>
						<img src="../../img/coke.jpg" alt="콜라" 
							style="width: 150px; height: 150px" /><br/>
						<figcaption>
						<input type="checkbox" name="coke-menu" value="cola"/>
							￦1,000
						<input type="number" name="coke-count" style="width: 30px" min="0" max="9"/> 개
						</figcaption>
						</figure>
					</td>
					<td>
						<figure>
						<img src="../../img/coffee.jpg" alt="커피" 
							style="width: 150px; height: 150px" /><br/>
						<figcaption>
						<input type="checkbox" name="coffee-menu" value="coffee"/>
							￦900
						<input type="number" name="coffee-count" style="width: 30px" min="0" max="9"/> 개
						</figcaption>
						</figure>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<input type="radio" name="place" value="매장식사" checked/> 매장식사
						<input type="radio" name="place" value="테이크아웃"/> 테이크아웃
							<!-- 체크박스와 라디오는 name이 같아야된다 -->
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<input type="hidden" name = "hamburger" value="5500" />
						<input type="hidden" name = "coke" value="1000" />
						<input type="hidden" name = "chip" value="1000" />
						<input type="hidden" name = "coffee" value="900" />
						<input type="hidden" name = "bagel" value="4000" />
						<input type="hidden" name = "salad" value="3500" />
						<input id="burgerking_order_btn" type="button" value="전  송" style="width: 100px; margin-left: 180px"/>
					</td>
				</tr>
			</table>
			</article>
		</form>
	</section>
<%@ include file="../common/footer.jsp" %>
</body>
</html>