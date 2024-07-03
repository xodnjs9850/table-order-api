package com.tableOrder.table_order.util;

import com.tableOrder.table_order.auth.model.SignInResponse;
import com.tableOrder.table_order.auth.model.Token;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TokenMapper {

    TokenMapper INSTANCE = Mappers.getMapper(TokenMapper.class);

    SignInResponse toSigninResponse(Token token);

}
