-- 검색을 위한 더미데이터 추가입력
INSERT INTO board 
	VALUES(seq_board_num.nextval, '지금은 봄입니다', '봄의 왈츠', 'musthave', sysdate, 0);
INSERT INTO board 
	VALUES(seq_board_num.nextval, '지금은 여름입니다', '여름향기', 'musthave', sysdate, 0);
INSERT INTO board 
	VALUES(seq_board_num.nextval, '지금은 가을입니다', '가을동화', 'musthave', sysdate, 0);
INSERT INTO board 
	VALUES(seq_board_num.nextval, '지금은 겨울입니다', '겨울연가', 'musthave', sysdate, 0);
	
commit;