local function expireAPI_1(keys, args)
   local key = keys[1]
--    过期时间
   local expire = args[1]
--    次数
   local count = args[2]
   if redis.call("exists",key) == 0 then
      redis.call("setex",key ,expire,1)
      return true
   end

   if redis.call('get',key) >= count then
       return false
   end
   redis.call('incr',key)
   return true
end
redis.register_function('expireAPI_1',expireAPI_1)

local function buy_13(keys,args)
    local key = keys[1]
    if redis.call("hget",key,'total') == '0' then
        return -1
    end
    return redis.call("hincrby",key,'total',-1)

end

redis.register_function("buy_13",buy_13)