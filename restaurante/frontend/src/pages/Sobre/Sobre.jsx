import './Sobre.css'

function Sobre() {
  return (
    <main className="sobre">

      <section className="sobre-intro">
        <span className="sobre-label">SOBRE NÓS</span>

        <h1>Brasa de Carvalho</h1>

        <p>
          Um restaurante pensado para reunir boa comida,
          bons momentos e uma experiência especial.
        </p>
      </section>

      <section className="sobre-conteudo">

        <div className="sobre-bloco">
          <h2>Nossa história</h2>

          <p>
            O Brasa de Carvalho nasceu com a proposta de criar
            um espaço acolhedor, onde os sabores marcantes e o
            cuidado em cada prato fazem parte da experiência.
          </p>
        </div>

        <div className="sobre-bloco">
          <h2>Nosso ambiente</h2>

          <p>
            Com uma identidade rústica e elegante, buscamos criar
            um ambiente confortável para aproveitar uma refeição,
            conversar e compartilhar bons momentos.
          </p>
        </div>

        <div className="sobre-bloco">
          <h2>Nossa proposta</h2>

          <p>
            Valorizamos uma experiência simples e bem cuidada:
            bons pratos, atendimento atencioso e um ambiente que
            faz você querer voltar.
          </p>
        </div>

      </section>

    </main>
  )
}

export default Sobre