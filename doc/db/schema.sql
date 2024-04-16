CREATE TABLE `B_FORECAST` (
    `FORECAST_SEQ` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '예보_시퀀스',
    `BASE_DATE` varchar(8) NOT NULL COMMENT '발표_일자',
    `BASE_TIME` varchar(6) NOT NULL COMMENT '발표_시각',
    `CATEGORY` varchar(3) NOT NULL COMMENT '자료구분코드',
    `NX` int(2) NOT NULL COMMENT '예보지점_X_좌표',
    `NY` int(2) NOT NULL COMMENT '예보지점_Y_좌표',
    `OBSR_VALUE` varchar(4) NOT NULL COMMENT '실황_값',
    PRIMARY KEY (`FORECAST_SEQ`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci COMMENT='BIGS_예보_테스트';