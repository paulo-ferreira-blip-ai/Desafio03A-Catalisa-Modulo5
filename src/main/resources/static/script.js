const modal = document.querySelector('.modal-container')
const tbody = document.querySelector('tbody')
const Nome = document.querySelector('#nome')
const Valor = document.querySelector('#valor')
const TipoContas = document.querySelector('#tipoContas')
const DataDeVencimento = document.querySelector('#dataDeVencimento')

let itens
let id

const getItensBD = () => JSON.parse(localStorage.getItem('gerenciador')) ?? []
const setItensBD = () => localStorage.setItem('gerenciador', JSON.stringify(itens))

function loadItens() {
    itens = getItensBD()
    tbody.innerHTML = ''
    itens.forEach((item, index) => {
        insertItem(item, index)
     })
  }
    loadItens()

    function insertItem(item, index) {
      let tr = document.createElement('tr')

      tr.innerHTML = `
        <td>${item.nome}</td>
        <td>R${item.valor}</td>
        <td>$ ${item.tipoContas}</td>
        <td>$ ${item.dataDeVencimento}</td>
        <td class="acao">
          <button onclick="editItem(${index})"><i class='bx bx-edit' ></i></button>
        </td>
        <td class="acao">
          <button onclick="deleteItem(${index})"><i class='bx bx-trash'></i></button>
        </td>
      `
      tbody.appendChild(tr)
    }

    function editItem(index) {

      openModal(true, index)
    }

    function deleteItem(index) {
      itens.splice(index, 1)
      setItensBD()
      loadItens()
    }

function openModal(edit = false, index = 0) {
  modal.classList.add('active')

  modal.onclick = e => {
    if (e.target.className.indexOf('modal-container') !== -1) {
      modal.classList.remove('active')
    }
  }

  if (edit) {
    Nome.value = itens[index].nome
    Valor.value = itens[index].valor
    TipoContas.value = itens[index].tipoContas
    DataDeVencimento.value = itens[index].dataDeVencimento
    id = index
  } else {
    Nome.value = ''
    Valor.value = ''
    TipoContas.value = ''
    DataDeVencimento.value = ''
  }
}

    btnSalvar.onclick = e => {

      if (Nome.value == '' || Valor.value == '' || TipoContas.value == '' || DataDeVencimento.valur == '') {
        return
      }

      e.preventDefault();

      if (id !== undefined) {
        itens[id].nome = Nome.value
        itens[id].valor = Valor.value
        itens[id].tipoContas = TipoContas.value
        itens[id].dataDeVencimento = DataDeVencimento.value
      } else {
        itens.push({'nome': Nome.value, 'valor': Valor.value, 'tipoContas': TipoContas.value, 'dataDeVencimento' : DataDeVencimento.value})
      }

      setItensBD()

      modal.classList.remove('active')
      loadItens()
      id = undefined
    }


