# Reflection, Schmeflection
Benchmark comparing reflection versus runtime built-in knowledge of method names. Using code generation (for example during annotation processing) we can add methods for "reflecting" (aka "schmeflecting") information about fields and methods that will return the same information as regular reflection, except that the cost is much lower.

This is useful for example, when binding values to beans from an `HttpServletRequest` or JSON. An alternative third option is to add bytecode generation during runtime which performs the same function as the "schmeflection" method.

```
Benchmark                      Mode  Cnt           Score          Error  Units
MyBenchmark.reflectionBean    thrpt   50     8225573.445 ±    87103.438  ops/s
MyBenchmark.shmeflectionBean  thrpt   50  3812902868.663 ± 51706523.841  ops/s
```

