package com.example.experiment2.dto;

import com.example.experiment2.dox.Address;
import com.example.experiment2.dox.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data//自动为类生成 getter 和 setter 方法、toString、equals、hashCode、canEqual 方法等，使得类的属性可以直接访问和修改。
@NoArgsConstructor//生成无参构造方法，这在一些框架（如 JPA 或 Jackson）中很有用，因为它们要求对象实例化时具有无参构造方法。
@AllArgsConstructor//生成包含所有字段的构造方法，方便一次性初始化所有属性。
@Builder//生成一个构建器（Builder）模式，允许用链式方法构建对象。通常在需要可读性更高的对象创建方式时非常有用。例如，可以使用 .builder() 创建对象，逐个设置属性，然后用 .build() 生成最终对象。
public class AddressUserDTO {
    private User user;
    private Address address;
}
