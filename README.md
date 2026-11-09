# Sistema Reengenheirado - Valor de Atendimento (clínica)

Reengenharia do legado `x_Mgr_F` (Granite Code 8B via Ollama + ajustes manuais do grupo).
Java 17 + Maven, com SRP, Strategy e Factory.

## Classes
- `CalculadoraValorAtendimento` - soma os procedimentos e delega o desconto
- `RegraDesconto` - interface (Strategy)
- `DescontoConvenio` (12% + taxa fixa 15,50 opcional), `DescontoParticular` (5% se > 500), `SemDesconto`
- `FabricaRegraDesconto` - escolhe a regra pelo tipo de atendimento
- `Main` - demonstração; testes JUnit comparam com o legado (`x_Mgr_F`, em `src/test`)

## Rodar localmente
```bash
mvn verify                   # compila, testa e gera cobertura (JaCoCo)
java -jar target/app.jar     # demonstração
docker build -t sistema-reengenheirado .
```

## Pipeline (GitHub Actions)
Dispara somente em tags `v*`:
```bash
git tag v1.0.0 && git push origin v1.0.0
```
Secrets: `SONAR_TOKEN`, `DOCKER_USERNAME`, `DOCKER_PASSWORD`.
